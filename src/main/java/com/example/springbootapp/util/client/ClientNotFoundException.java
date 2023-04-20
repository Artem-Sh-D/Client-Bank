package com.example.springbootapp.util.client;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException() {}

    public ClientNotFoundException(String msg) {
        super(msg);
    }
}
