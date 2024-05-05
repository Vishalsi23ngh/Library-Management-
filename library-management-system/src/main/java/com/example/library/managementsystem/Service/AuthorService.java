package com.example.library.managementsystem.Service;

import com.example.library.managementsystem.Entity.Author;
import com.example.library.managementsystem.Entity.Book;
import com.example.library.managementsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping("/add")
    public  String addAuthor(Author author){
        author.setNoOfBooks(0);
        authorRepository.save(author);
        return "Author has been saved to database";
    }


}

