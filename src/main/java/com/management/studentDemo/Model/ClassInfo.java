package com.management.studentDemo.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class ClassInfo {
    @Id
    private String className;
    @NotNull
    @OneToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacher;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
