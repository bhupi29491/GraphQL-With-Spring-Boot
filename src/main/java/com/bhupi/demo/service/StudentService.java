package com.bhupi.demo.service;

import com.bhupi.demo.entity.Student;
import com.bhupi.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }
}
