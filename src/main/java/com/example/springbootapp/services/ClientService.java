package com.example.springbootapp.services;

import com.example.springbootapp.model.Client;
import com.example.springbootapp.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findClientByFirstName(String firstName) {
       return clientRepository.findClientByFirstName(firstName);
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public Client findClientById(int id) {
        return clientRepository.findClientById(id);
    }

    public Client findClientByEmail(String email) {
        return clientRepository.findClientByEmail(email);
    }

    public Client findClientBySecondName(String secondName) {
        return clientRepository.findClientBySecondName(secondName);
    }

}
