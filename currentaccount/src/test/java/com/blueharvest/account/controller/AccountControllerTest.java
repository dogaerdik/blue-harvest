package com.blueharvest.account.controller;

import com.blueharvest.account.datahelper.DataHelperTest;
import com.blueharvest.account.service.impl.AccountCommandServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountControllerTest {

    private AccountCommandServiceImpl accountCommandService;
    DataHelperTest dataHelperTest = new DataHelperTest();

    @Before
    public void setup() {
        accountCommandService = mock(AccountCommandServiceImpl.class);
    }

    @Test
    public void createCurrentAccountTest() {
        when(accountCommandService.createCurrentAccount(dataHelperTest.generateAccountDTO())).thenReturn(dataHelperTest.generateAccountDTO());
        assertNotNull(accountCommandService.createCurrentAccount(dataHelperTest.generateAccountDTO()));
    }

}
