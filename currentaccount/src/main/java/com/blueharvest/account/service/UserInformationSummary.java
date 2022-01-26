package com.blueharvest.account.service;

public interface UserInformationSummary {
    Long getId();

    Long getCustomerId();

    String getBalance();

    String getAccountNumber();

    String getCreatedDate();

    String getName();

    String getSurName();

    String getTransactionType();
}
