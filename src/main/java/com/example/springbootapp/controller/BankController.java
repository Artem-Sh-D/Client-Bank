package com.example.springbootapp.controller;

import com.example.springbootapp.model.Bank;
import com.example.springbootapp.services.BankService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankController {

    private BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/{id}")
    public Bank getBank(@PathVariable int id) {
        return bankService.findBankById(id);
    }

    @PostMapping("/new")
    public void saveBank(@RequestBody Bank bank) {
        bankService.saveBank(bank);
    }

    @PutMapping("/update/{id}")
    public void updateBank(@PathVariable int id, @RequestBody Bank bank) {

    }
}
