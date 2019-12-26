package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ConsumerClient {
    private String url;
    private RestTemplate restTemplate;

    @Autowired
    public ConsumerClient(@Value("${serviceUrl}") String url) {
        this.url = url;
        this.restTemplate = new RestTemplate();
    }

    public List<pactDemo> pactDemo() {
        ParameterizedTypeReference<List<pactDemo>> responseType = new ParameterizedTypeReference<List<pactDemo>>() {};
        return restTemplate.exchange(url + "/pactDemo", HttpMethod.GET, null, responseType).getBody();
    }
}
