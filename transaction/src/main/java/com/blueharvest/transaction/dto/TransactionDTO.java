package com.blueharvest.transaction.dto;

import com.blueharvest.transaction.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
public class TransactionDTO {
    private Long id;

    @Column(unique = true)
    private Long accountId;

    private String accountNumber;

    private Double amount;

    private TransactionType transactionType;
}
