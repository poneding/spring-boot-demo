package com.pding.spring_boot_demo.dao;

import com.pding.spring_boot_demo.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface StudentRepository
        extends JpaRepository<Student,Long> {

    /**
     * 根据邮箱判断学生是否已经存在
     * @param email 学生邮箱
     * @return 如果存在返回true，否则返回false
     */
    Boolean existsStudentByEmail(String email);

    /**
     * 根据年龄范围获取学生列表
     * @param ageAfter 最小年龄
     * @param ageBefore 最大年龄
     * @return 学生列表
     */
    List<Student> getByAgeBetween(int ageAfter, int ageBefore);
}
