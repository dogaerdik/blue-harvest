package com.blueharvest.transaction.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class CustomAuditorAware implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("D.Erdik");
    }

}