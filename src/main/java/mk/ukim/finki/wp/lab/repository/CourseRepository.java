package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.DataHolder.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class CourseRepository {
    List<Course> courseList;

    public CourseRepository(List<Course> courseList) {
        this.courseList = DataHolder.courseList;
    }

    public List<Course> findAllCourses() {
        return courseList;
    }



   public Optional<Course> findById(Long courseId) {
        return courseList.stream().filter(course -> Long.parseLong(course.getCourseId().toString()) == courseId).findFirst();
    }



    public List<Student> findAllStudentsByCourse(Long courseId) {
        return courseList.stream().filter(course -> course.getCourseId() == courseId).findFirst().get().getStudents();

    }



    public Optional<Course> addStudentToCourse(Student student, Optional<Course> course) {


      List<Student> students = new ArrayList<>(course.get().getStudents());
      students.add(student);
      course.get().setStudents(students);
        return course;
    }
    public Course save(Course c){
        this.courseList.add(c);
        return c;
    }
    public Course delete(Course c){
        this.courseList.remove(c);
        return c;
    }





}
