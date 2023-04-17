package com.example.springbootapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;


@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    @NotEmpty(message = "First name should not be empty")
    @Size(min = 2, max = 30, message = "First name should be between 2 and 30 characters")
    private String firstName;

    @Column(name = "second_name")
    @NotEmpty(message = "Second name should not be empty")
    @Size(min = 2, max = 30, message = "Second name should be between 2 and 30 characters")
    private String secondName;

    @Column(name = "email")
    @Email
    @NotEmpty(message = "Email should not be empty")
    private String email;

    @Column(name = "phone_number")
    @Pattern(regexp = "^(\\+7|7|8)?[\\s\\-]?\\(?[489][0-9]{2}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}$", message = "Does not match the russian number")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    private Bank bank;



    public Client() {
    }

    public Client(String firstName, String secondName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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

        if (id != client.id) return false;
        if (!Objects.equals(firstName, client.firstName)) return false;
        if (!Objects.equals(secondName, client.secondName)) return false;
        if (!Objects.equals(email, client.email)) return false;
        if (!Objects.equals(phoneNumber, client.phoneNumber)) return false;
        return Objects.equals(bank, client.bank);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        return result;
    }

}
