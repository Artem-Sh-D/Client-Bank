package com.example.springbootapp.services;

import com.example.springbootapp.model.Bank;
import com.example.springbootapp.repositories.BankRepository;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    private BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public void save(Bank bank) {
        bankRepository.save(bank);
    }

    public Bank findBankById(int id) {
        return bankRepository.findBankById(id);
    }

    public Bank findBankByBankName(String bankName) {
        return bankRepository.findClientByBankName(bankName);
    }

    public Bank findBankByBankSerialNumber(Long serialNumber) {
        return bankRepository.findClientByBankSerialNumber(serialNumber);
    }
}
