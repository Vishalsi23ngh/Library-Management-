package com.example.library.managementsystem.Repository;

import com.example.library.managementsystem.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author ,Integer> {

}
