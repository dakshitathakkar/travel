package com.triptrace.travel.client;

import org.springframework.web.client.RestTemplate;

public class BaseRestClient {
    private static RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        if(null == restTemplate) restTemplate = new RestTemplate();
        return restTemplate;
    }
}
