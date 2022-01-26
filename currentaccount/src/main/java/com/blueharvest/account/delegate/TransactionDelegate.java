package com.blueharvest.account.delegate;

import com.blueharvest.account.dto.TransactionDTO;

public interface TransactionDelegate {

    TransactionDTO saveTransaction(TransactionDTO transactionDTO);

    TransactionDTO getTransactionByAccountId(Long accountId);
}
