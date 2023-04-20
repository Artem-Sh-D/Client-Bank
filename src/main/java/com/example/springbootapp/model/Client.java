package com.example.springbootapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.Objects;


@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname")
    @NotEmpty(message = "First name should not be empty")
    @Size(min = 2, max = 30, message = "First name should be between 2 and 30 characters")
    private String firstname;

    @Column(name = "lastname")
    @NotEmpty(message = "Lastname should not be empty")
    @Size(min = 2, max = 30, message = "Second name should be between 2 and 30 characters")
    private String lastname;

    @Column(name = "email")
    @Email
    @NotEmpty(message = "Email should not be empty")
    private String email;

    @Column(name = "phone_number")
    @Pattern(regexp = "^(\\+7|7|8)?[\\s\\-]?\\(?[489][0-9]{2}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}$", message = "Does not match the russian number")
    private String phoneNumber;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    @Column(name = "created_by")
    @NotEmpty
    private String createdBy;

    @ManyToOne(fetch = FetchType.EAGER)
    private Bank bank;



    public Client() {
    }

    public Client(String firstname, String lastname, String email, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(firstname, client.firstname) && Objects.equals(lastname, client.lastname) && Objects.equals(email, client.email) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(created, client.created) && Objects.equals(updated, client.updated) && Objects.equals(createdBy, client.createdBy) && Objects.equals(bank, client.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, email, phoneNumber, created, updated, createdBy, bank);
    }
}
