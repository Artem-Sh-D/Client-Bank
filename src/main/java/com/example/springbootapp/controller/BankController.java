package com.example.springbootapp.controller;

import com.example.springbootapp.dto.BankDTO;
import com.example.springbootapp.model.Bank;
import com.example.springbootapp.services.BankService;
import com.example.springbootapp.util.bank.BankErrorResponse;
import com.example.springbootapp.util.bank.BankNotCreateException;
import com.example.springbootapp.util.bank.BankNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public List<Bank> getBanks() {
        return bankService.findAll();
    }

    @PostMapping(value = "/new")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid BankDTO bankDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }

            throw new BankNotCreateException(errorMessage.toString());
        }
        bankService.save(convertToBank(bankDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Bank convertToBank(BankDTO bankDTO) {
        Bank bank = new Bank();

        bank.setBankName(bankDTO.getBankName());
        bank.setBankSerialNumber(bankDTO.getBankSerialNumber());

        return bank;
    }

    @ExceptionHandler
    private ResponseEntity<BankErrorResponse> handleException(BankNotFoundException e) {
        BankErrorResponse response = new BankErrorResponse(
                "Bank with this id wasn't found !",
                System.currentTimeMillis()
        );

        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<BankErrorResponse> handleException(BankNotCreateException e) {
        BankErrorResponse response = new BankErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
