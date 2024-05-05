package com.example.library.managementsystem.Repository;

import com.example.library.managementsystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student ,Integer> {
}
