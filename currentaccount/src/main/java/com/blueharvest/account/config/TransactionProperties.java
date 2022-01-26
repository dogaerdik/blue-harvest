package com.blueharvest.account.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "transaction")
public class TransactionProperties {
    private String saveTransactionUrl;
    private String findAllByAccountUrl;
}
