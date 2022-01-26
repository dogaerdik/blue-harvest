package com.blueharvest.account.delegate;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service("restBaseService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestBaseService {

     RestTemplate restTemplate = new RestTemplate();

    public <T, K> K post(String url, T body, Class<K> responseType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return send(url, body, responseType, HttpMethod.POST, httpHeaders);
    }

    public <T, K> K send(String url, T body, Class<K> responseClassType, HttpMethod method, HttpHeaders httpHeaders) {
        return send(this.restTemplate, url, body, responseClassType, method, httpHeaders);
    }

    public <T, K> K send(RestTemplate template, String url, T body, Class<K> responseClassType, HttpMethod method, HttpHeaders httpHeaders) {
        return exchange(template, url, body, responseClassType, method, httpHeaders).getBody();
    }

    private <T, K> ResponseEntity<K> exchange(RestTemplate template, String url, T body, Class<K> responseClassType, HttpMethod method, HttpHeaders httpHeaders) {
        try {
            return template.exchange(
                    url,
                    method,
                    new HttpEntity<>(body, httpHeaders),
                    responseClassType);
        } catch (ResourceAccessException ex) {
            log.error(ex.getMessage());
            throw new ResourceAccessException("Service Access Error!");
        }
    }

    public <T> T get(String url, Class<T> responseType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return send(url, null, responseType, HttpMethod.GET, httpHeaders);
    }

}
