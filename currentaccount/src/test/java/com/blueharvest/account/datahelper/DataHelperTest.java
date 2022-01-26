package com.blueharvest.account.datahelper;

import com.blueharvest.account.domain.Account;
import com.blueharvest.account.dto.AccountDTO;

import java.util.Date;

public class DataHelperTest {
    Date date = new Date();

    public AccountDTO generateAccountDTO() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setInitialCredit(10.00);
        accountDTO.setCustomerId(0L);
        accountDTO.setBalance(50.00);
        accountDTO.setCustomerId(10154L);
        return accountDTO;
    }

    public AccountDTO generateAccountDTONonCustomer() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setInitialCredit(10.00);
        accountDTO.setCustomerId(0L);
        accountDTO.setBalance(50.00);
        accountDTO.setCustomerId(10154L);
        accountDTO.setAccountNumber("123-465-54");
        return accountDTO;
    }

    public Account generateAccount() {
        Account account = new Account();
        account.setBalance(account.getBalance());
        account.setCustomerId(account.getCustomerId());
        account.setId(account.getId());
        account.setCreatedDate(account.getCreatedDate());
        account.setAccountNumber("123-465-54");
        return account;
    }
}
