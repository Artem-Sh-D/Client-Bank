package com.example.springbootapp.controller;

import com.example.springbootapp.model.Bank;
import com.example.springbootapp.model.Client;
import com.example.springbootapp.services.BankService;
import com.example.springbootapp.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;
    private BankService bankService;

    public ClientController(ClientService clientService, BankService bankService) {
        this.clientService = clientService;
        this.bankService = bankService;
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable int id) {
        return clientService.findClientById(id);
    }

    @GetMapping("/allClient")
    public List<Client> getClients() {
        return clientService.findAll();
    }

    @PostMapping(value = "/new")
    public void setClient(@RequestBody Client client) {
        clientService.saveClient(client);
    }



}
