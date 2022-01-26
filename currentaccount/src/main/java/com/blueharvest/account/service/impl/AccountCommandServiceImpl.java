package com.blueharvest.account.service.impl;

import com.blueharvest.account.domain.Customer;
import com.blueharvest.account.dto.TransactionDTO;
import com.blueharvest.account.dto.UserInformationSummaryDTO;
import com.blueharvest.account.enums.TransactionType;
import com.blueharvest.account.repository.CustomerRepository;
import com.blueharvest.account.service.AccountCommandService;
import com.blueharvest.account.delegate.TransactionDelegate;
import com.blueharvest.account.domain.Account;
import com.blueharvest.account.dto.AccountDTO;
import com.blueharvest.account.exception.BusinessValidationException;
import com.blueharvest.account.repository.AccountRepository;
import com.blueharvest.account.validator.AccountBusinessValidatorRule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Transactional
public class AccountCommandServiceImpl implements AccountCommandService {

    private final ModelMapper mapper;
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final TransactionDelegate transactionDelegate;

    @Override
    public AccountDTO createCurrentAccount(AccountDTO accountDTO) {
        if (customerRepository.countById(accountDTO.getCustomerId()) == 0) {
            throw new BusinessValidationException(AccountBusinessValidatorRule.CUSTOMER_NOT_FOUND,
                    AccountBusinessValidatorRule.CUSTOMER_NOT_FOUND.getCode());
        } else if (accountDTO.getInitialCredit() <= 0)
            throw new BusinessValidationException(AccountBusinessValidatorRule.INITIAL_CREDIT_AMOUNT_GREATER_ZERO,
                    AccountBusinessValidatorRule.INITIAL_CREDIT_AMOUNT_GREATER_ZERO.getCode());
        else if (customerRepository.countById(accountDTO.getId()) > 0)
            throw new BusinessValidationException(AccountBusinessValidatorRule.ACCOUNT_CREATED_BEFORE,
                    AccountBusinessValidatorRule.ACCOUNT_CREATED_BEFORE.getCode());
        else {
            accountDTO.setBalance(accountDTO.getInitialCredit());
            AccountDTO accountDTOs = Optional.of(mapper.map(accountDTO, Account.class))
                    .map(accountRepository::save)
                    .map(account -> mapper.map(account, AccountDTO.class))
                    .orElse(null);

            TransactionDTO transactionDTO = getTransactionDTOfromAccountDTO(accountDTOs, TransactionType.CREATED_ACCOUNT);
            transactionDelegate.saveTransaction(transactionDTO);

            return accountDTOs;
        }
    }

    public TransactionDTO getTransactionDTOfromAccountDTO(AccountDTO accountDTO, TransactionType transactionType) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAccountId(accountDTO.getId());
        transactionDTO.setTransactionType(transactionType);
        transactionDTO.setAmount(accountDTO.getBalance());
        transactionDTO.setAccountNumber(accountDTO.getAccountNumber());
        return transactionDTO;
    }

    @Override
    public List<Customer> getSampleCustomerData() {
        return customerRepository.findAll();
    }

    public String getTransactionByAccountId(Long accountId) {
        return transactionDelegate.getTransactionByAccountId(accountId).getTransactionType().toString();
    }

    public List<UserInformationSummaryDTO> getUserInformation(Long customerId) {
        return accountRepository.getUserInformation(customerId).stream()
                .map(u -> new UserInformationSummaryDTO(u.getId(), u.getCustomerId(), u.getBalance(), u.getAccountNumber(),
                        u.getCreatedDate(), u.getName(), u.getSurName(), getTransactionByAccountId(u.getId()))).collect(Collectors.toList());
    }
}
