package com.example.InterviewV2.dao;

import com.example.InterviewV2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Long> {
}
