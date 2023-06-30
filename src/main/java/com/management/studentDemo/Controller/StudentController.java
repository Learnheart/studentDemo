package com.management.studentDemo.Controller;

import com.management.studentDemo.Model.Student;
import com.management.studentDemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    //    get the list of students
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/student")
    private List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/student/{studentId}")
    private Student getStudentById(@PathVariable("studentId") long studentId) {
        return studentService.getStudentById(studentId);
    }

    //  add new student
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/student/addNewStudent")
    private Student addNewStudent(@RequestBody Student student) {
        return studentService.addNewStudent(student);
    }

    //    delete a student
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteStudent/{studentId}")
    private void deleteStudent(@PathVariable("studentId") long studentId) {
        studentService.deleteStudent(studentId);
    }

    //    update student
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateStudent/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student newStudent) {
        Optional<Student> updatedStudent = studentService.updateStudent(studentId, newStudent);
        if (updatedStudent.isPresent()) {
            return ResponseEntity.ok(updatedStudent.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
