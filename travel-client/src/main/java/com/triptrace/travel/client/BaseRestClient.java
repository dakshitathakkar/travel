package com.triptrace.travel.client;

import org.springframework.web.client.RestTemplate;

/**
 * Base class for common implementations
 */
public class BaseRestClient {
    private static RestTemplate restTemplate;

    /**
     * Rest Template constructor
     * @return
     */
    public RestTemplate getRestTemplate() {
        if(null == restTemplate) restTemplate = new RestTemplate();
        return restTemplate;
    }
}
