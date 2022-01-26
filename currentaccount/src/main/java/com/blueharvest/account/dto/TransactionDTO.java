package com.blueharvest.account.dto;

import com.blueharvest.account.enums.TransactionType;
import lombok.Data;

@Data
public class TransactionDTO {
    private Long id;

    private Long accountId;

    private String accountNumber;

    private Double amount;

    private TransactionType transactionType;
}
