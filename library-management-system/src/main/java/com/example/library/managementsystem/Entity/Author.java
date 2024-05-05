package com.example.library.managementsystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Author {

    @Id
    private  Integer authorId;

    private Integer age;

    private  String name;

    private  String emailId;

    private  double rating;

    private  int noOfBooks;
}
