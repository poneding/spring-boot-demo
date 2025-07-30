package com.pding.spring_boot_demo.controller;

import com.pding.spring_boot_demo.Response;
import com.pding.spring_boot_demo.dto.StudentDTO;
import com.pding.spring_boot_demo.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/api/v1/students")
@RestController
@Tag(name = "学生管理接口", description = "提供学生信息的增删改查功能")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Response<StudentDTO> getStudentById(@PathVariable long id) {
        try {
            StudentDTO studentDto= studentService.getById(id);
            return Response.success(studentDto);
        } catch (Throwable e) {
            // 处理异常
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping
    public Response<List<StudentDTO>> getByAgeRange(@RequestParam int minAge, @RequestParam int maxAge) {
        try {
            List<StudentDTO> students = studentService.getByAgeRange(minAge, maxAge);
            return Response.success(students);
        } catch (Throwable e) {
            // 处理异常
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping
    public Response<StudentDTO> add(StudentDTO studentDTO) {
        try {
            return Response.success(studentService.add(studentDTO));

        }catch (Throwable e){
            // 处理异常
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/{id}")
    public Response<StudentDTO> updateById(@PathVariable long id, @RequestParam(required = false) String name,
                                           @RequestParam(required = false) String email,
                                           @RequestParam(required = false) int age) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(name);
        studentDTO.setEmail(email);
        studentDTO.setAge(age);

        try {
            return Response.success(studentService.updateById(id, studentDTO));
        } catch (Throwable e) {
            // 处理异常
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public Response<Object> deleteById(@PathVariable long id) {
        try {
            studentService.deleteById(id);
            return Response.success();
        } catch (Throwable e) {
            // 处理异常
            e.printStackTrace();
            return Response.error("删除失败: " + e.getMessage());
        }
    }

}
