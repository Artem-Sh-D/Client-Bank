package com.example.springbootapp.controller;

import com.example.springbootapp.model.Client;
import com.example.springbootapp.services.ClientService;
import com.example.springbootapp.util.client.ClientErrorResponse;
import com.example.springbootapp.util.client.ClientNotCreateException;
import com.example.springbootapp.util.client.ClientNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable int id) {
        return clientService.findClientById(id);
    }

    @GetMapping()
    public List<Client> getClients() {
        return clientService.findAll();
    }

    @PostMapping(value = "/new")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Client client,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }

            throw new ClientNotCreateException(errorMessage.toString());
        }
        clientService.save(client);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ClientErrorResponse> handleException(ClientNotFoundException e) {
        ClientErrorResponse response = new ClientErrorResponse(
                "Client with this id wasn't found !",
                System.currentTimeMillis()
        );

        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<ClientErrorResponse> handleException(ClientNotCreateException e) {
        ClientErrorResponse response = new ClientErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
