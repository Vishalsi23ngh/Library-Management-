package com.example.library.managementsystem.Entity;

import com.example.library.managementsystem.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int bookId;

    @Column(unique = true)
    private String title;

    private  int noOfPages;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private Integer price;

    private  Boolean IsIssued;

    @JoinColumn
    @ManyToOne
    private Author author;
}
