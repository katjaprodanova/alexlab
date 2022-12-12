package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;

import java.util.List;
import java.util.Optional;

public interface CourseService{
    List<Student> listStudentsByCourse(Long courseId);
    Optional<Course> addStudentInCourse(String username, Long courseId);
    List<Course> listAll();
    Optional<Course> findById(Long id);
    Course saveCourse(String name,String description, Long teacherId);
    Course editCourse(Long id,String name,String description, Long teacherId);
    Course delete(Long id);
}