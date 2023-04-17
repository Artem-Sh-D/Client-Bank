package com.example.springbootapp.util.client;

public class ClientNotUpdateException extends RuntimeException {
    public ClientNotUpdateException(String msg) {
        super(msg);
    }
}
