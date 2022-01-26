package com.blueharvest.account.dto;

import lombok.Data;

@Data
public class AccountDTO {

    private Long id;

    private Long customerId;

    private Double balance;

    private Double initialCredit;

    private String accountNumber;
}
