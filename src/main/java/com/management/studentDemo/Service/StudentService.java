package com.management.studentDemo.Service;

import com.management.studentDemo.Model.Student;
import com.management.studentDemo.Repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    //    Add
    public Student addNewStudent(Student student) {
        return studentDao.save(student);
    }
    //    Show all records
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        studentDao.findAll().forEach(student -> studentList.add(student));
        return studentList;
    }
    //    show product by id
    public Student getStudentById(Long studentId) {
        return studentDao.findById(studentId).get();
    }
    //    delete record by id
    public void deleteStudent(Long studentId) {
        studentDao.deleteById(studentId);
    }

    //    Update student by id
    public Optional<Student> updateStudent(long studentId, Student newStudent) {
        return studentDao.findById(studentId).map(
                oldStudent -> {
                    oldStudent.setStudentName(String.valueOf(newStudent.getStudentId()));
                    oldStudent.setStudentName(newStudent.getStudentName());
                    oldStudent.setStdBirth(newStudent.getStdBirth());
//                    oldStudent.setClassInfo(newStudent.getClassInfo());

                    return studentDao.save(oldStudent);
                }
        );
    }

}
