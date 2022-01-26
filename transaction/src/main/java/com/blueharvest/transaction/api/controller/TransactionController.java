package com.blueharvest.transaction.api.controller;

import com.blueharvest.transaction.api.constants.ApiEndpoints;
import com.blueharvest.transaction.domain.Transaction;
import com.blueharvest.transaction.dto.TransactionDTO;
import com.blueharvest.transaction.service.impl.TransactionCommandServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = ApiEndpoints.URL_CONVERTER, produces = ApiEndpoints.RESPONSE_CONTENTTYPE)
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionController {
    private final TransactionCommandServiceImpl transactionCommandService;

    @PostMapping(value = "transaction")
    public ResponseEntity<TransactionDTO> saveTransaction(@Valid @RequestBody TransactionDTO transactionDTO) {
        return new ResponseEntity<>(transactionCommandService.saveTransaction(transactionDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/accountId/{accountId}")
    public ResponseEntity<Optional<TransactionDTO>> findByAccountId(@PathVariable Long accountId) {
        return new ResponseEntity<Optional<TransactionDTO>>(transactionCommandService.findByAccountId(accountId), HttpStatus.OK);
    }

    @GetMapping(value = "/accountNumber/{accountNumber}")
    public ResponseEntity<List<Transaction>> findByAccountNumber(@PathVariable String accountNumber) {
        return new ResponseEntity<List<Transaction>>(transactionCommandService.findByAccountNumber(accountNumber), HttpStatus.OK);
    }
}
