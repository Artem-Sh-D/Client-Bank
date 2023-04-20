package com.example.springbootapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;


@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bank_name")
    @NotEmpty(message = "Bank name should not be empty")
    @Size(min = 2, max = 30, message = "Bank name should be between 2 and 30 characters")
    private String name;

    @Column(name = "serial_number")
    private long serialNumber;

    @OneToMany(mappedBy = "bank")
    private List<Client> clients;
    public Bank() {
    }

    public Bank(String name, long serialNumber) {
        this.name = name;
        this.serialNumber = serialNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setClients(Client client) {
       this.clients.add(client);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return id == bank.id && serialNumber == bank.serialNumber && Objects.equals(name, bank.name) && Objects.equals(clients, bank.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, serialNumber, clients);
    }
}
