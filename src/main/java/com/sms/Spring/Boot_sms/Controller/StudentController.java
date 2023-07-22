package com.sms.Spring.Boot_sms.Controller;


import com.sms.Spring.Boot_sms.Entity.Student;
import com.sms.Spring.Boot_sms.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
    }


    @GetMapping("/getStudent")
    public List<Student> getStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/getStudentById/{s_id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int s_id) {
        Student student = studentService.getStudentById(s_id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateStudent/{s_id}")
    public Student updateStudent(@PathVariable int s_id, @RequestBody Student student) {
        return studentService.updateStudent(s_id, student);
    }

    @DeleteMapping("deleteStudent/{s_id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(required = false) int s_id) {
        studentService.deleteStudentById(s_id);
        return new ResponseEntity<>("Delete Student Successfully!", HttpStatus.OK);
    }


    @PutMapping("/{s_id}/course/{c_id}")
    public Student enroll(
            @PathVariable int s_id,
            @PathVariable int c_id
    ) {
        return studentService.enroll(s_id, c_id);
    }
}


