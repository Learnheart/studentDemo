package com.management.studentDemo.Service;

import com.management.studentDemo.Model.ClassInfo;
import com.management.studentDemo.Model.Student;
import com.management.studentDemo.Repository.ClassInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassInfoService {
    @Autowired
    ClassInfoDao classInfoDao;

    //    Add
    public ClassInfo addClassInfo(ClassInfo classInfo) {
        return classInfoDao.save(classInfo);
    }

    //    View
    public List<ClassInfo> getClassInfo() {
        List<ClassInfo> classInfoList = new ArrayList<>();
        classInfoDao.findAll().forEach(classInfo -> classInfoList.add(classInfo));
        return classInfoList;
    }

    public ClassInfo getClassInfoById(String className) {
        return classInfoDao.findById(className).get();
    }

    //    Delete
    public void deleteClassInfo(String className) {
        classInfoDao.deleteById(className);
    }

    //    Update
    public Optional<ClassInfo> updateClassInfo(String className, ClassInfo newClassInfo) {
        return classInfoDao.findById(className).map(
                oldClassInfo -> {
                    oldClassInfo.setClassName(newClassInfo.getClassName());
                    oldClassInfo.setTeacher(newClassInfo.getTeacher());

                    return classInfoDao.save(oldClassInfo);
                }
        );
    }
}
