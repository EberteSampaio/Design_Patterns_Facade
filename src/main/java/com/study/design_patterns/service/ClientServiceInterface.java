package com.study.design_patterns.service;

import com.study.design_patterns.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ClientServiceInterface {
    List<Client> searchAll();

    Optional<Client> findyById(Long id);

    Client create(Client client);

    Client update(Long id, Client client);

    void delete (Long id);
}
