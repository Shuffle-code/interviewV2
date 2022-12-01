package com.example.InterviewV2.controller;

import com.example.InterviewV2.entity.Student;
import com.example.InterviewV2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/all")
    public String getPlayerList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student_list";
    }

    @GetMapping("/{studentId}")
    public String showInfo(Model model, @PathVariable(name = "studentId") Long id) {
        Student student;
        if (id != null) {
            student = studentService.findById(id);
        } else {
            return "redirect:/student/all";
        }
        model.addAttribute("student", student);
        return "student_info";
    }

    @GetMapping
    public String showForm(Model model, @RequestParam(name = "id", required = false) Long id) {
        Student student;
        if (id != null) {
            student = studentService.findById(id);
        } else {
            student = new Student();
        }
        model.addAttribute("student", student);
        return "student_form";
    }

    @PostMapping("/add")
    public String savePlayer(Student student) {
        studentService.save(student);
        return "redirect:/student/all";
    }

    @GetMapping("/delete/{Id}")
    public String deleteById(@PathVariable(name = "Id") Long id) {
        studentService.deleteById(id);
        return "redirect:/student/all";
    }

}
