package com.example.springbootapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ClientCreateDTO {
    @NotEmpty(message = "Firstname should not be empty")
    @Size(min = 2, max = 30, message = "Firstname should be between 2 and 30 characters")
    private String firstname;

    @NotEmpty(message = "Lastname should not be empty")
    @Size(min = 2, max = 30, message = "Lastname should be between 2 and 30 characters")
    private String lastname;

    @Email
    @NotEmpty(message = "Email should not be empty")
    private String email;

    @Pattern(regexp = "^(\\+7|7|8)?[\\s\\-]?\\(?[489][0-9]{2}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}$", message = "Does not match the russian number")
    private String phoneNumber;

    public ClientCreateDTO(String firstname, String lastname, String email, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
}
