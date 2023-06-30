package com.management.studentDemo.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long teacherId;
    private String teacherName;
    private String subject;
//    @OneToMany(mappedBy = "classInfo", cascade = CascadeType.MERGE)
    @OneToMany
    private List<Student> students;

    public long getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
