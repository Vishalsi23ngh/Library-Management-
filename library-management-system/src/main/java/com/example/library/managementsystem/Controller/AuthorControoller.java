package com.example.library.managementsystem.Controller;

import com.example.library.managementsystem.Entity.Author;
import com.example.library.managementsystem.Entity.Book;
import com.example.library.managementsystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorControoller {

    @Autowired
    private AuthorService authorService;

    @PostMapping("add")
    public String addAuthor(@RequestBody Author author){
        String result =authorService.addAuthor(author);
        return  result;
    }



}
