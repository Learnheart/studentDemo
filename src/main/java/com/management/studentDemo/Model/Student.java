package com.management.studentDemo.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Student {
    @Id
    @Column (name = "Id")
    private long studentId;
    @Column(name = "Name")
    @NotBlank(message = "Please fill the blank")
    private String studentName;
    @Column(name = "Date_of_birth")
    private String stdBirth;
//    @ManyToOne
//    @JoinColumn(name = "className")
//    private ClassInfo classInfo;
//    public Student() {}

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStdBirth() {
        return stdBirth;
    }

    public void setStdBirth(String stdBirth) {
        this.stdBirth = stdBirth;
    }

//    public ClassInfo getClassInfo() {
//        return classInfo;
//    }
//
//    public void setClassInfo(ClassInfo classInfo) {
//        this.classInfo = classInfo;
//    }
}
