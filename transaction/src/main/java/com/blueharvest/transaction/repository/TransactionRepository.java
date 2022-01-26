package com.blueharvest.transaction.repository;

import com.blueharvest.transaction.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findByAccountId(Long accountId);
    List<Transaction>  findByAccountNumber(String accountNumber);
}
