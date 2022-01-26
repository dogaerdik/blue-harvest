package com.blueharvest.account.api.controller;

import com.blueharvest.account.domain.Customer;
import com.blueharvest.account.dto.UserInformationSummaryDTO;
import com.blueharvest.account.api.constants.ApiEndpoints;
import com.blueharvest.account.dto.AccountDTO;
import com.blueharvest.account.service.impl.AccountCommandServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = ApiEndpoints.URL_CONVERTER, produces = ApiEndpoints.RESPONSE_CONTENTTYPE)
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountController {

    private final AccountCommandServiceImpl accountCommandService;

    @PostMapping(value = "/account")
    public ResponseEntity<AccountDTO> createCurrentAccount(@Valid @RequestBody AccountDTO accountDTO) {
        return new ResponseEntity<>(accountCommandService.createCurrentAccount(accountDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/customer")
    public List<Customer> findByIdentityNumber() {
        return accountCommandService.getSampleCustomerData();
    }

    @GetMapping(value = "/user/{customerId}")
    public List<UserInformationSummaryDTO>  getUserInformation(@PathVariable Long customerId) {
        return accountCommandService.getUserInformation(customerId);
    }
}
