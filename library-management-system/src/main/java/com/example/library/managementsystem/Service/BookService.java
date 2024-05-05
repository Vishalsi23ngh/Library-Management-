package com.example.library.managementsystem.Service;

import com.example.library.managementsystem.Entity.Author;
import com.example.library.managementsystem.Entity.Book;
import com.example.library.managementsystem.Exeptions.InvalidPageCountException;
import com.example.library.managementsystem.Repository.AuthorRepository;
import com.example.library.managementsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private  AuthorRepository authorRepository;
    public  String addBook(Book book) throws Exception{

        if(book.getNoOfPages() <= 0){
            throw new InvalidPageCountException("page count should be greater than 0");
        }
        bookRepository.save(book);
        return " book has been added to database";
    }


    public  String associateBookAndAuthor( Integer bookId , Integer authorId) throws Exception{

        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if(bookOptional.isEmpty()){
            //throws an exception that book is not found
            throw new Exception("book id entered is incorrect");
        }

        Book book = bookOptional.get();

        //Book book = bookRepository.findById(bookId).get();

        Optional<Author> authorOptional = authorRepository.findById(authorId);

        if(bookOptional.isEmpty()){
            // throws an exception that author is not present
            throw new Exception("author id entered is incorrect");
        }

        Author author = authorOptional.get();
        //Author author = authorRepository.findById(authorId).get();

        //associate book and author
        book.setAuthor(author);
        author.setNoOfBooks(author.getNoOfBooks() + 1);

        bookRepository.save(book);
        authorRepository.save(author);

        return " book and author is associated";
    }
    public List<Book> findBookByAuthor(Integer authorId){
        List<Book> allBooks = bookRepository.findAll();
        // I need to iterate    where book.getauthor.getId is matching
        List<Book> ansList = new ArrayList<>();

        for(Book book: allBooks){
            if(book.getAuthor().getAuthorId().equals(authorId)){
                ansList.add(book);
            }
        }
        return  ansList;
    }
}
