package com.blueharvest.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInformationSummaryDTO {
    private Long Id;

    private Long customerId;

    private String balance;

    private String accountNumber;

    private String createdDate;

    private String name;

    private String surName;

    private String transactionType;
}
