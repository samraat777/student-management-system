package com.sam.sms.controller;

import com.sam.sms.entity.Student;
import com.sam.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    //handler method to handle list students and return model and view
    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model)
    {
        //Create Empty Student to hold student form data
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudents(@ModelAttribute("student") Student student)
    {
        studentService.saveStudent(student);
        return "redirect:/students";

    }

    @GetMapping("/student/edit/{id}")
    public String editStudentForm(@PathVariable Long id,Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student ,Model model)
    {
        //get student from data base via id
        Student exsistingStudent = studentService.getStudentById(id);
        exsistingStudent.setId(id);
        exsistingStudent.setFirstName(student.getFirstName());
        exsistingStudent.setLastName(student.getLastName());
        exsistingStudent.setEmail(student.getEmail());

        //Save Exsisting student
        studentService.updateStudent(exsistingStudent);
        return "redirect:/students";

    }


    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
