package com.blueharvest.account.exception;

import com.blueharvest.account.validator.BusinessValidationRule;

public class BusinessValidationException extends RuntimeException {

    private final BusinessValidationRule rule;

    public BusinessValidationException(BusinessValidationRule rule) {
        this.rule = rule;
    }

    public BusinessValidationException(BusinessValidationRule rule, String message) {
        super(message);
        this.rule = rule;
    }

    public BusinessValidationException(BusinessValidationRule rule, String message, Throwable cause) {
        super(message, cause);
        this.rule = rule;
    }

    public BusinessValidationRule getRule() {
        return rule;
    }
}
