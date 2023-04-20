package com.example.springbootapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class BankCreateDTO {

    @NotEmpty(message = "Bank name should not be empty")
    @Size(min = 2, max = 30, message = "Bank name should be between 2 and 30 characters")
    private String bankName;

    private long bankSerialNumber;

    public BankCreateDTO(String bankName, long bankSerialNumber) {
        this.bankName = bankName;
        this.bankSerialNumber = bankSerialNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public long getBankSerialNumber() {
        return bankSerialNumber;
    }

    public void setBankSerialNumber(long bankSerialNumber) {
        this.bankSerialNumber = bankSerialNumber;
    }
}
