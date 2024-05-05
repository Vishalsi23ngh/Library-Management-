package com.example.library.managementsystem.Controller;

import com.example.library.managementsystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @PostMapping("issuedBook")
    public String  issuedBook(@RequestParam("cardId") Integer cardId , @RequestParam("bookId") Integer bookId){

        try{
            String result = transactionService.issuedBook(bookId,cardId);
            return  result;
        }catch (Exception e){
            return  e.getMessage();
        }
    }
}
