package com.blueharvest.transaction.domain;

import com.blueharvest.transaction.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreatedDate
    private Date createdDate;
    @Column(unique = true)
    private Long accountId;

    private String accountNumber;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
}