package com.management.studentDemo.Controller;

import com.management.studentDemo.Model.ClassInfo;
import com.management.studentDemo.Model.Student;
import com.management.studentDemo.Service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClassInfoController {
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/classInfo/addClassInfo")
    private ClassInfo newClass(@RequestBody ClassInfo classInfo) {
        return classInfoService.addClassInfo(classInfo);
    }

    @Autowired
    ClassInfoService classInfoService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/classInfo")
    private List<ClassInfo> classInfoList() {
        return classInfoService.getClassInfo();
    }

    @GetMapping("/classInfo/{className}")
    @PreAuthorize("hasAnyRole ('ADMIN', 'TEACHER')")
    private ClassInfo getClassInfoById(@PathVariable("className") String className) {
        return classInfoService.getClassInfoById(className);
    }

    @PreAuthorize("hasRole ('ADMIN')")
    @DeleteMapping("/deleteClassInfo/{className}")
    private void deleteClassInfo(@PathVariable("className") String className) {
        classInfoService.deleteClassInfo(className);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateClassInfo/{className}")
    public ResponseEntity<ClassInfo> updateClassInfo(@PathVariable String className, @RequestBody ClassInfo newClassInfo) {
        Optional<ClassInfo> updatedClass = classInfoService.updateClassInfo(className, newClassInfo);
        if (updatedClass.isPresent()) {
            return ResponseEntity.ok(updatedClass.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
