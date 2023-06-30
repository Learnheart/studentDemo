package com.management.studentDemo.Service;

import com.management.studentDemo.Model.Student;
import com.management.studentDemo.Model.Teacher;
import com.management.studentDemo.Repository.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;

    public Teacher addNewTeacher(Teacher teacher) {
        return teacherDao.save(teacher);
    }
    //    Show all records
    public List<Teacher> getAllTeacher() {
        List<Teacher> teacherList = new ArrayList<>();
        teacherDao.findAll().forEach(teacher -> teacherList.add(teacher));
        return teacherList;
    }

//    public List<Teacher> getAllTeacher() {
//        return teacherDao.findAll();
//    }
    //    show product by id
    public Teacher getTeacherById(Long teacherId) {
        return teacherDao.findById(teacherId).get();
    }
    //    delete record by id
    public void deleteTeacher(Long teacherId) {
        teacherDao.deleteById(teacherId);
    }

    //    Update student by id
    public Optional<Teacher> updateTeacher(long teacherId, Teacher newTeacher) {
        return teacherDao.findById(teacherId).map(
                oldTeacher -> {
                    oldTeacher.setTeacherName(newTeacher.getTeacherName());
                    oldTeacher.setSubject(newTeacher.getSubject());
                    oldTeacher.setStudents(newTeacher.getStudents());

                    return teacherDao.save(oldTeacher);
                }
        );
    }

}
