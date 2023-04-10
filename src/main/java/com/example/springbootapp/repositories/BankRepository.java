package com.example.springbootapp.repositories;

import com.example.springbootapp.model.Bank;
import com.example.springbootapp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank,Integer> {

    public Bank findBankById(int id);
    public Bank findClientByBankName(String bankName);

    public Bank findClientByBankSerialNumber(Long bankSerialNumber);

}
