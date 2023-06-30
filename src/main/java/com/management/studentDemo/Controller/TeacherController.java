package com.management.studentDemo.Controller;

import com.management.studentDemo.Model.Student;
import com.management.studentDemo.Model.Teacher;
import com.management.studentDemo.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/teacher")
    private List<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("/teacher/{teacherId}")
    private Teacher getTeacherById(@PathVariable("teacherId") long teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    //  add new student
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/teacher/addNewTeacher")
    private Teacher addNewTeacher(@RequestBody Teacher teacher) {
        return teacherService.addNewTeacher(teacher);
    }

    //    delete a student
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteTeacher/{teacherId}")
    private void deleteTeacher(@PathVariable("teacherId") long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }

    //    update student
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateTeacher/{teacherId}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("teacherId") Long teacherId, @RequestBody Teacher newTeacher) {
        Optional<Teacher> updatedTeacher = teacherService.updateTeacher(teacherId, newTeacher);
        if (updatedTeacher.isPresent()) {
            return ResponseEntity.ok(updatedTeacher.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
