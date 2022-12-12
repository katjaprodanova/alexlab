package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.DataHolder.DataHolder;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherRepository {

   public List<Teacher> teacherList;

    public TeacherRepository(List<Teacher> teacherList) {
        this.teacherList = DataHolder.teacherList;
    }

    public List<Teacher> findAll(){
        return teacherList;
    }
    public Teacher findById(Long id){
        return this.teacherList.stream().filter(teacher -> Long.parseLong(teacher.getId().toString()) == id).findFirst().get();
    }

}
