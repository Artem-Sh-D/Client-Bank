package com.example.springbootapp.services;

import com.example.springbootapp.model.Bank;
import com.example.springbootapp.util.bank.BankNotFoundException;
import com.example.springbootapp.repositories.BankRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    private BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Bank findBankById(int id) {
        Optional<Bank> bank = bankRepository.findById(id);
        return bank.orElseThrow(BankNotFoundException::new);
    }

    public List<Bank> findAll() {
        return bankRepository.findAll();
    }

    public void save(Bank bank) {
        bankRepository.save(bank);
    }

}
