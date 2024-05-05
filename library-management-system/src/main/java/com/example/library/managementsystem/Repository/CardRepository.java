package com.example.library.managementsystem.Repository;

import com.example.library.managementsystem.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<LibraryCard ,Integer> {
}
