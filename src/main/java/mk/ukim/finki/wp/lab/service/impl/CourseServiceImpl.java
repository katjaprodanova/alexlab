package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.repository.TeacherRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;
    private final TeacherRepository teacherRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentService studentService,TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return this.courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Optional<Course> addStudentInCourse(String username, Long courseId) {
        Student s = this.studentService.listAll().stream().filter(student -> student.getUsername().equals(username)).findFirst().get();
        Optional<Course> c = this.courseRepository.findById(courseId);
        return this.courseRepository.addStudentToCourse(s,c);
    }

    @Override
    public List<Course> listAll() {
        return this.courseRepository.findAllCourses();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return this.courseRepository.findById(id);
    }

    @Override
    public Course saveCourse(String name, String description, Long teacher) {
        Teacher t = this.teacherRepository.findById(teacher);
        List<Student> list = new ArrayList<>();
        Course course = new Course(name,description,list,t);
        return this.courseRepository.save(course);

    }

    @Override
    public Course editCourse(Long id, String name, String description, Long teacherId) {
       Course course = this.courseRepository.findById(id).orElseThrow(()->new RuntimeException());
        course.setName(name);
        course.setDescription(description);
        Teacher t = this.teacherRepository.findById(teacherId);
        course.setTeacher(t);
        return this.courseRepository.save(course);

    }

    @Override
    public Course delete(Long id) {
        Course c = this.courseRepository.findById(id).get();
        return this.courseRepository.delete(c);
    }
}
