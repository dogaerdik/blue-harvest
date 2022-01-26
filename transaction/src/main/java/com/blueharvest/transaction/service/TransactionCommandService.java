package com.blueharvest.transaction.service;

import com.blueharvest.transaction.domain.Transaction;
import com.blueharvest.transaction.dto.TransactionDTO;

import java.util.List;
import java.util.Optional;

public interface TransactionCommandService {
    TransactionDTO saveTransaction(TransactionDTO transactionDTO);
    Optional<TransactionDTO> findByAccountId(Long accountId);
    List<Transaction>  findByAccountNumber(String accountNumber);

}
