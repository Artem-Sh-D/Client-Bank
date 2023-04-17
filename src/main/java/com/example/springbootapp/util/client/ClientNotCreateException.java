package com.example.springbootapp.util.client;

public class ClientNotCreateException extends RuntimeException {
    public ClientNotCreateException(String msg) {
        super(msg);
    }
}
