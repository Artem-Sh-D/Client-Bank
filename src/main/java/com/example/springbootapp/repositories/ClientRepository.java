package com.example.springbootapp.repositories;

import com.example.springbootapp.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

    public Client findClientByEmail(String email);
    public Client findClientByLastname(String secondName);
    public Client findClientByFirstname(String firstName);
}
