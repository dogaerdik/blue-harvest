package com.blueharvest.account.service;

import com.blueharvest.account.dto.UserInformationSummaryDTO;
import com.blueharvest.account.domain.Customer;
import com.blueharvest.account.dto.AccountDTO;

import java.util.List;

public interface AccountCommandService {

    AccountDTO createCurrentAccount(AccountDTO accountDTO);

    List<Customer> getSampleCustomerData();

    List<UserInformationSummaryDTO> getUserInformation(Long customerId);
}
