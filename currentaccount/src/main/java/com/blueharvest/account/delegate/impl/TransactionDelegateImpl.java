package com.blueharvest.account.delegate.impl;

import com.blueharvest.account.config.TransactionProperties;
import com.blueharvest.account.delegate.RestBaseService;
import com.blueharvest.account.dto.TransactionDTO;
import com.blueharvest.account.exception.CallServiceException;
import com.blueharvest.account.delegate.TransactionDelegate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Transactional
public class TransactionDelegateImpl implements TransactionDelegate {

    private final RestBaseService restBaseService;
    private final TransactionProperties transactionProperties;

    @Override
    public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {

        try {
            return
                    restBaseService.post(transactionProperties.getSaveTransactionUrl(), transactionDTO, TransactionDTO.class);
        } catch (Exception e) {
            log.error("Unsuccessful service call. URL: " + transactionProperties.getSaveTransactionUrl(), e);
            throw new CallServiceException("Service access error !");
        }
    }

    @Override
    public TransactionDTO getTransactionByAccountId(Long accountId) {
        try {
            return
                    restBaseService.get(transactionProperties.getFindAllByAccountUrl() + accountId, TransactionDTO.class);
        } catch (Exception e) {
            log.error("Unsuccessful service call. URL: " + transactionProperties.getFindAllByAccountUrl(), e);
            throw new CallServiceException("Service access error !");
        }
    }
}
