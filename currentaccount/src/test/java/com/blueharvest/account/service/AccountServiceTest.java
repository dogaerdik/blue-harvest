package com.blueharvest.account.service;

import com.blueharvest.account.datahelper.DataHelperTest;
import com.blueharvest.account.delegate.impl.TransactionDelegateImpl;
import com.blueharvest.account.domain.Account;
import com.blueharvest.account.dto.AccountDTO;
import com.blueharvest.account.exception.BusinessValidationException;
import com.blueharvest.account.repository.AccountRepository;
import com.blueharvest.account.repository.CustomerRepository;
import com.blueharvest.account.service.impl.AccountCommandServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTest {
    private ModelMapper mapper;
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private AccountCommandServiceImpl accountCommandService;
    private TransactionDelegateImpl transactionDelegate;
    DataHelperTest dataHelperTest = new DataHelperTest();

    @Before
    public void setup() {
        accountRepository = mock(AccountRepository.class);
        customerRepository = mock(CustomerRepository.class);
        mapper = mock(ModelMapper.class);
        transactionDelegate = mock(TransactionDelegateImpl.class);

        accountCommandService = new AccountCommandServiceImpl(mapper, accountRepository, customerRepository,transactionDelegate);

        mapper = mock(ModelMapper.class);
    }

    @Test(expected = BusinessValidationException.class)
    public void createCurrentAccountTest() {

        Account account = dataHelperTest.generateAccount();
        account.setCustomerId(0L);
        when(customerRepository.countById(account.getCustomerId())).thenReturn(0L);
        accountCommandService.createCurrentAccount(dataHelperTest.generateAccountDTO());
    }

    @Test(expected = BusinessValidationException.class)
    public void createCurrentAccountTest2() {
        AccountDTO accountDTO = dataHelperTest.generateAccountDTO();
        accountDTO.setInitialCredit(0.00);
        accountCommandService.createCurrentAccount(accountDTO);

    }


}
