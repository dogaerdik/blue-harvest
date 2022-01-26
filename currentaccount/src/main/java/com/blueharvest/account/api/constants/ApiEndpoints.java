package com.blueharvest.account.api.constants;

import org.springframework.http.MediaType;

public final class ApiEndpoints {
    public static final String RESPONSE_CONTENTTYPE = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8";

    public static final String API_BASE_URL = "/api";

    public static final String URL_CONVERTER = API_BASE_URL + "/currentAccount";

    private ApiEndpoints() {

    }
}
