package com.example.library.managementsystem.Service;

import com.example.library.managementsystem.Entity.Book;
import com.example.library.managementsystem.Entity.LibraryCard;
import com.example.library.managementsystem.Entity.Transaction;
import com.example.library.managementsystem.Enums.TransactionStatus;
import com.example.library.managementsystem.Repository.BookRepository;
import com.example.library.managementsystem.Repository.CardRepository;
import com.example.library.managementsystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private CardRepository cardRepository;

    public static Integer MAX_NO_OF_ISSUED_BOOKS = 3;

    public String issuedBook(Integer cardId, Integer bookId) throws  Exception{
        // find book and card from the repository
        //create transaction object
        //set the relevent attribute of transacggion object
        //change the attribute of card and book Entity



        //1 Book and Library card should be valid
        //Book book = bookRepository.findById(bookId).get();

        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isEmpty()){
            throw new Exception(" book is not present");
        }
        Book book = bookOptional.get();


        //2. Library card should be valid
        Optional<LibraryCard> optionalLibraryCard = cardRepository.findById(cardId);
        if(optionalLibraryCard.isEmpty()){
            throw  new Exception(" Invalid library card");
        }
        LibraryCard card = optionalLibraryCard.get();



        Transaction transaction = new Transaction();
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionStatus(TransactionStatus.PENDING);



        // 3. book should not be already issued
        if(book.getIsIssued()){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            return "book is already issued to CardId" + card.getCardNo();
        }




        // 4. Limit of card is exceeded
        if(card.getNoOfBookIssued()>MAX_NO_OF_ISSUED_BOOKS){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            return  " Maximum no of card limit has been exceeded";
        }




        //5. check for card is expired or not
        LocalDate currentDate = LocalDate.now();
        if( currentDate.isAfter(card.getValadity())){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transactionRepository.save(transaction);
            return "card has been expired";
        }



        book.setIsIssued(true);
        card.setNoOfBookIssued(card.getNoOfBookIssued() +1);
        //  whatever is modified should be saved
        cardRepository.save(card);
        bookRepository.save(book);
        transaction = transactionRepository.save(transaction);

        return  " the transaction has be completed with transaction id" + transaction.getTransactionId();
    }
}
