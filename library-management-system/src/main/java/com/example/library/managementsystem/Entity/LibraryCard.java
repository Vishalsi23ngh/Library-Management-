package com.example.library.managementsystem.Entity;

import com.example.library.managementsystem.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer cardNo;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    private  int noOfBookIssued;

    private LocalDate valadity;

    @JoinColumn
    @OneToOne
    private Student student;
}
