package com.example.springbootapp.controller;

import com.example.springbootapp.model.Client;
import com.example.springbootapp.services.BankService;
import com.example.springbootapp.services.ClientService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/new")
    public void sayHello(@RequestBody Client client) {
        clientService.saveClient(client);
    }


}
