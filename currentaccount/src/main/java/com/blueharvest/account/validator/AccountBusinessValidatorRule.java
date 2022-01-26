package com.blueharvest.account.validator;

public enum AccountBusinessValidatorRule implements BusinessValidationRule{

    CUSTOMER_NOT_FOUND("CUSTOMER_NOT_FOUND", " CUSTOMER NOT FOUND !"),
    INITIAL_CREDIT_AMOUNT_GREATER_ZERO("INITIAL_CREDIT_AMOUNT_GREATER_ZERO","INITIAL CREDIT AMOUNT MUST BE GREATER ZERO !"),
    ACCOUNT_CREATED_BEFORE("ACCOUNT_CREATED_BEFORE","THERE IS AN ACCOUNT WITH THIS ID !")
    ;

    private final String code;
    private final String description;

    AccountBusinessValidatorRule(String code, String description) {
        this.code = code;
        this.description = description;
    }
    @Override
    public String getCode() {
        return  code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
