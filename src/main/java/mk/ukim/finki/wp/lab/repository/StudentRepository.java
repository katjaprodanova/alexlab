package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.DataHolder.DataHolder;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
   public List<Student> studentList;

    public StudentRepository(List<Student> studentList) {
        this.studentList = DataHolder.studentList;
    }

   public List<Student> findAllStudents(){
        return studentList;
    };
   public Optional<Student> findAllByNameOrSurname(String text){
        return studentList.stream().filter(student -> student.getName().equals(text) || student.getSurname().equals(text) || student.getUsername().equals(text)).findFirst();
    };

}
