package com.pding.spring_boot_demo.service;

import com.pding.spring_boot_demo.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    /**
     * 根据ID获取学生信息
     * @param id 学生ID
     * @return 学生DTO
     * @throws Exception 如果学生不存在或其他错误
     */
    StudentDTO getById(long id) throws Exception;

    /**
     * 根据年龄范围获取学生列表
     * @param minAge 最小年龄
     * @param maxAge 最大年龄
     * @return 学生DTO列表
     */
    List<StudentDTO> getByAgeRange(int minAge, int maxAge);

    /**
     * 添加新学生
     * @param studentDTO 学生DTO
     * @return 新学生的ID
     * @throws Exception 如果学生已存在或其他错误
     */
    StudentDTO add(StudentDTO studentDTO) throws Exception;

    /**
     * 根据ID更新学生信息
     * @param id 学生ID
     * @param studentDTO 学生DTO
     * @return 更新后的学生DTO
     * @throws Exception 如果学生不存在或其他错误
     */
    StudentDTO updateById(long id, StudentDTO studentDTO) throws Exception;

    /**
     * 根据ID删除学生
     * @param id 学生ID
     * @throws Exception 如果学生不存在或其他错误
     */
    void deleteById(long id) throws Exception;
}
