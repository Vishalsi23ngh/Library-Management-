package com.example.library.managementsystem.Service;

import com.example.library.managementsystem.Entity.Student;
import com.example.library.managementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public  String addStudent(Student student){
        studentRepository.save(student);

        return  "student is saved to DB";
    }
}
