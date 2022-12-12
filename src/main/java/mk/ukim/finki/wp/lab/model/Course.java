package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.List;
@Data
public class Course {
    Long courseId;
    String name;
    String description;
    List<Student> students;
    Teacher teacher;
    public Course(Long courseId, String name, String description, List<Student> students) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.students = students;
    }
    public Course( String name, String description, List<Student> students) {
        this.courseId = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.students = students;
    }

    public Course(String name, String description, List<Student> students, Teacher teacher) {
        this.name = name;
        this.description = description;
        this.students = students;
        this.teacher = teacher;
    }
}
