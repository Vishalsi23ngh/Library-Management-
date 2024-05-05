package com.example.library.managementsystem.Entity;

import com.example.library.managementsystem.Enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public  String transactionId;

    @Enumerated(value =  EnumType.STRING)
    private TransactionStatus transactionStatus;

    @CreatedDate
    private Date issueDate;


    private Date returnDate;

    private  Integer fineAmount;

    @ManyToOne
    @JoinColumn
    private  LibraryCard card;

    @JoinColumn
    @ManyToOne
    private Book book;
}
