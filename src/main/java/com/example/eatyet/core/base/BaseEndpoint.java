package com.example.eatyet.core.base;

import com.example.eatyet.core.APIMethod;
import com.example.eatyet.core.RestApiEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseEndpoint {
    protected static final Logger logger = LoggerFactory.getLogger(RestApiEndpoint.class);
    protected String url;

    public BaseEndpoint(String url) {
        this.url = url;
    }

    protected void beforeAdvice(APIMethod method, String value) {
        logger.info("{} - {} method: {}",this.getClass(), method , url + value);
    }

    protected void afterAdvice(String msg) {
        logger.info(this.getClass() + " - Message: " + msg);
    }
}
