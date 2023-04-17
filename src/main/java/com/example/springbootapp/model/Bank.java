package com.example.springbootapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
    private String bankName;

    @Column(name = "serial_number")
    @NotEmpty(message = "Serial number should not be empty")
    @Pattern(regexp = "")
    private long bankSerialNumber;

    @OneToMany(mappedBy = "bank")
    private List<Client> clients;
    public Bank() {
    }

    public Bank(String bankName, long bankSerialNumber) {
        this.bankName = bankName;
        this.bankSerialNumber = bankSerialNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() { return bankName; }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public long getBankSerialNumber() {
        return bankSerialNumber;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setNewClients(List<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.removeIf(client1 -> client1 == client);
    }

    public void setBankSerialNumber(long bankSerialNumber) {
        this.bankSerialNumber = bankSerialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bank bank = (Bank) o;

        if (id != bank.id) return false;
        if (bankSerialNumber != bank.bankSerialNumber) return false;
        if (!Objects.equals(bankName, bank.bankName)) return false;
        return Objects.equals(clients, bank.clients);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bankName != null ? bankName.hashCode() : 0);
        result = 31 * result + (int) (bankSerialNumber ^ (bankSerialNumber >>> 32));
        result = 31 * result + (clients != null ? clients.hashCode() : 0);
        return result;
    }
}
