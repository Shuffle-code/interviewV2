package com.example.InterviewV2.service;

import com.example.InterviewV2.dao.StudentDao;
import com.example.InterviewV2.entity.Student;
import lombok.RequiredArgsConstructor;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentDao studentDao;

    public List<Student> findAll(){
        return studentDao.findAll();
    }

    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return studentDao.findById(id).orElse(null);
    }

    public void save(Student student){
        studentDao.save(student);
    }
    private String getName(){
        DataFactory df = new DataFactory();
        return df.getFirstName();
    }
    public static double getMark(int max) {
        return (double) (Math.random() * ++max);
    }
    public Student createStudent(){
        return Student.builder().
                name(getName()).
                mark(getMark(5)).
                build();
    }
    public boolean deleteById(Long id){
        studentDao.deleteById(id);
        return true;
    }
}
