package com.pding.spring_boot_demo.converter;

import com.pding.spring_boot_demo.entity.Student;
import com.pding.spring_boot_demo.dto.StudentDTO;
import org.springframework.beans.BeanUtils;

public class StudentConverter {

    public  static StudentDTO convertStudent(Student student) {
        if (student == null) {
            return null;
        }

        // StudentDTO dto = new StudentDTO();
        // dto.setId(student.getId());
        // dto.setName(student.getName());
        // dto.setEmail(student.getEmail());
        // dto.setAge(student.getAge());

        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(student, studentDTO);

        return studentDTO;
    }

    public static Student convertStudentDTO(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }

        Student student = new Student();
        BeanUtils.copyProperties(studentDTO,student);
        return student;
    }

}
