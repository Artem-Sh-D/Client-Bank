package com.example.springbootapp.services;

import com.example.springbootapp.dto.ClientUpdateDTO;
import com.example.springbootapp.model.Bank;
import com.example.springbootapp.model.Client;
import com.example.springbootapp.repositories.BankRepository;
import com.example.springbootapp.repositories.ClientRepository;
import com.example.springbootapp.util.client.ClientNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {
    private ClientRepository clientRepository;

    private BankRepository bankRepository;

    public ClientService(ClientRepository clientRepository, BankRepository bankRepository) {
        this.clientRepository = clientRepository;
        this.bankRepository = bankRepository;
    }

    public Client findClientById(int id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(ClientNotFoundException::new);
    }

    public Client findClientByFirstName(String firstName) {
       return clientRepository.findClientByFirstname(firstName);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void save(Client client) {
        enrichClient(client);
        clientRepository.save(client);
    }

    public void update(int id, ClientUpdateDTO clientUpdateDTO) {
        Client client = findClientById(id);
        if(clientUpdateDTO.getPhoneNumber() != null) {
            client.setPhoneNumber(clientUpdateDTO.getPhoneNumber());
        }
        if(clientUpdateDTO.getEmail() != null) {
            client.setEmail(clientUpdateDTO.getEmail());
        }
        clientRepository.save(client);
    }

    public void delete(int id) {
        if(clientRepository.findById(id).isEmpty()) {
            throw new ClientNotFoundException();
        }
        clientRepository.delete(findClientById(id));
    }

    public void setBankClient(int id, String bankName) {
            Client client = findClientById(id);
            Bank bank = bankRepository.findBankByName(bankName);
            client.setBank(bank);
            bank.setClients(client);
    }

    private void enrichClient(Client client) {
        client.setCreated(LocalDateTime.now());
        client.setUpdated(LocalDateTime.now());
        client.setCreatedBy("ADMIN");
    }

    public Client findClientByEmail(String email) {
        return clientRepository.findClientByEmail(email);
    }

    public Client findClientBySecondName(String secondName) {
        return clientRepository.findClientByLastname(secondName);
    }



}
