package com.example.eatyet.core;

public enum APIMethod {
    GET ("GET"),
    POST("POST"),
    DELETE("POST"),
    PUT ("PUT");

    public final String value;
    APIMethod(String value) {
        this.value = value;
    }
}
