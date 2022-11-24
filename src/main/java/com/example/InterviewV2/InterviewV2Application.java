package com.example.InterviewV2;

import com.example.InterviewV2.entity.Student;
import com.example.InterviewV2.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class InterviewV2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(InterviewV2Application.class, args);
		StudentService studentServiceBeen = context.getBean(StudentService.class);
//		List<Student> all = studentServiceBeen.findAll();
//		for (Student s :all
//			 ) {
//			System.out.println(s.getId() + " " + s.getName());
//		}
		System.out.println(studentServiceBeen.findByID(30l));
		studentServiceBeen.deleteById(30l);
		System.out.println("____");
		System.out.println(studentServiceBeen.findByID(30l));
		System.out.println(studentServiceBeen.findByID(31l));
//		studentServiceBeen.save(new Student("Jack", 5));
//		System.out.println();
//		for (int i = 0; i < 2000; i++) {
//			studentServiceBeen.save(studentServiceBeen.createStudent());
//		}

	}

}
