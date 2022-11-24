package com.example.InterviewV2.service;

import com.example.InterviewV2.dao.StudentDao;
import com.example.InterviewV2.entity.Student;
import lombok.RequiredArgsConstructor;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentDao studentDao;

    public List<Student> findAll(){
        return studentDao.findAll();
    }
    public Optional<Student> findByID(Long id){
        return studentDao.findById(id);
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
