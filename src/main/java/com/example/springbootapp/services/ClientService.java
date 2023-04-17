package com.example.springbootapp.services;

import com.example.springbootapp.model.Client;
import com.example.springbootapp.repositories.ClientRepository;
import com.example.springbootapp.util.client.ClientNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findClientById(int id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(ClientNotFoundException::new);
    }

    public Client findClientByFirstName(String firstName) {
       return clientRepository.findClientByFirstName(firstName);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void save(Client client) {
        enrichClient(client);
        clientRepository.save(client);
    }

    private void enrichClient(Client client) {
        client.setCreatedAt(LocalDateTime.now());
        client.setUpdateAt(LocalDateTime.now());
        client.setCreatedWho("ADMIN");
    }

    public Client findClientByEmail(String email) {
        return clientRepository.findClientByEmail(email);
    }

    public Client findClientBySecondName(String secondName) {
        return clientRepository.findClientBySecondName(secondName);
    }

}
