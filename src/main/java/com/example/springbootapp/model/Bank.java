package com.example.springbootapp.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bankName;

    private long bankSerialNumber;



    public Bank() {
    }

    public Bank(String bankName, long bankSerialNumber) {
        this.bankName = bankName;
        this.bankSerialNumber = bankSerialNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
