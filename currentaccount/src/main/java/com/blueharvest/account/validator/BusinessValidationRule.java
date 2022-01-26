package com.blueharvest.account.validator;

import java.io.Serializable;

public interface BusinessValidationRule extends Serializable {
    String getCode();

    String getDescription();
}
