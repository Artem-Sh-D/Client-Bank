package com.example.springbootapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class BankCreateDTO {

    @NotEmpty(message = "Bank name should not be empty")
    @Size(min = 2, max = 30, message = "Bank name should be between 2 and 30 characters")
    private String name;

    private long serialNumber;

    public BankCreateDTO(String name, long serialNumber) {
        this.name = name;
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }
}
