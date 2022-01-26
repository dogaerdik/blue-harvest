package com.blueharvest.transaction.service.impl;

import com.blueharvest.transaction.domain.Transaction;
import com.blueharvest.transaction.dto.TransactionDTO;
import com.blueharvest.transaction.repository.TransactionRepository;
import com.blueharvest.transaction.service.TransactionCommandService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionCommandServiceImpl implements TransactionCommandService {

    private final ModelMapper mapper;
    private final TransactionRepository transactionRepository;

    @Override
    public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {

        return Optional.of(mapper.map(transactionDTO, Transaction.class))
                .map(transactionRepository::save)
                .map(account -> mapper.map(account, TransactionDTO.class))
                .orElse(null);
    }

    @Override
    public Optional<TransactionDTO> findByAccountId(Long accountId) {
        Optional<TransactionDTO> transactionDTO = Objects.nonNull(transactionRepository.findByAccountId(accountId)) ?
                Optional.of(mapper.map(transactionRepository.findByAccountId(accountId), TransactionDTO.class)) : null;
        return transactionDTO;
    }

    @Override
    public List<Transaction> findByAccountNumber(String accountNumber) {
        return  Optional.of(transactionRepository.findByAccountNumber(accountNumber)).orElse(null);
    }

}
