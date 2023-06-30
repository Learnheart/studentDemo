package com.management.studentDemo.Repository;

import com.management.studentDemo.Model.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassInfoDao extends JpaRepository<ClassInfo, String> {
}
