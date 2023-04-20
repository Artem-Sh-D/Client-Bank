package com.example.springbootapp.controller;

import com.example.springbootapp.dto.ClientCreateDTO;
import com.example.springbootapp.dto.ClientUpdateDTO;
import com.example.springbootapp.model.Client;
import com.example.springbootapp.services.ClientService;
import com.example.springbootapp.util.client.ClientErrorResponse;
import com.example.springbootapp.util.client.ClientNotCreateException;
import com.example.springbootapp.util.client.ClientNotFoundException;
import com.example.springbootapp.util.client.ClientNotUpdateException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping(value = "/new")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid ClientCreateDTO client,
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
        clientService.save(covertToClient(client));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable int id, @RequestBody ClientUpdateDTO clientUpdateDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }

            throw new ClientNotUpdateException(errorMessage.toString());
        }
        clientService.update(id, clientUpdateDTO);


        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/{id}/addbank")
    public ResponseEntity<HttpStatus> setBankClient(@PathVariable int id, @RequestBody String bankName,
                                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }

            throw new ClientNotFoundException(errorMessage.toString());
        }
        clientService.setBankClient(id, bankName);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        clientService.delete(id);
    }

    private Client covertToClient(ClientCreateDTO clientCreateDTO) {
        Client client = new Client();

        client.setFirstName(clientCreateDTO.getFirstName());
        client.setSecondName(clientCreateDTO.getSecondName());
        client.setEmail(clientCreateDTO.getEmail());
        client.setPhoneNumber(clientCreateDTO.getPhoneNumber());

        return client;
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
