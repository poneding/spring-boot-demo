package com.pding.spring_boot_demo.service;

import com.pding.spring_boot_demo.converter.StudentConverter;
import com.pding.spring_boot_demo.entity.Student;
import com.pding.spring_boot_demo.dao.StudentRepository;
import com.pding.spring_boot_demo.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired // 注入StudentRepository
    private StudentRepository studentRepository;

    @Override
    public StudentDTO getById(long id) {
        Student student =  studentRepository.findById(id).orElseThrow(RuntimeException::new);
        return StudentConverter.convertStudent(student);
    }

    @Override
    public List<StudentDTO> getByAgeRange(int minAge, int maxAge) {
        List<Student> students = studentRepository.getByAgeBetween(minAge, maxAge);

        return students.stream().map(StudentConverter::convertStudent).toList();
    }

    @Override
    public StudentDTO add(StudentDTO studentDTO) throws Exception {
        if (studentRepository.existsStudentByEmail(studentDTO.getEmail())) {
            throw new Exception("Email already exists");
        }

        Student student = StudentConverter.convertStudentDTO(studentDTO);
        student = studentRepository.save(student);

        studentDTO.setId(student.getId());
        return studentDTO;
    }

    @Override
    public StudentDTO updateById(long id, StudentDTO studentDTO) throws Exception {
        if (!studentRepository.existsById(id)) {
            throw new Exception("Student not found");
        }

        Student student = StudentConverter.convertStudentDTO(studentDTO);
        student.setId(id); // 设置ID以便更新

        student = studentRepository.save(student);
        return StudentConverter.convertStudent(student);
    }

    @Override
    public void deleteById(long id) throws Exception {
        if (!studentRepository.existsById(id)) {
            throw new Exception("Student not found");
        }

        studentRepository.deleteById(id);
    }
}
