package com.study.design_patterns.service.impl;

import com.study.design_patterns.model.Address;
import com.study.design_patterns.model.Client;
import com.study.design_patterns.repository.AddressRepository;
import com.study.design_patterns.repository.ClientRepository;
import com.study.design_patterns.service.ClientServiceInterface;
import com.study.design_patterns.service.ViaCepServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ClientService implements ClientServiceInterface {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepServiceInterface viaCepService;

    @Override
    public List<Client> searchAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findyById(Long id) {
        return this.clientRepository.findById(id);
    }

    @Override
    public Client create(Client client) {

        client.setAddress(this.searchAddress(client));

        return clientRepository.save(client);
    }

    @Override
    public Client update(Long id, Client client) {

        return this.clientRepository.findById(id).map(client1 -> {

            client1.setAddress(this.searchAddress(client));

            return this.clientRepository.save(client1);
        }).orElseThrow();

    }

    @Override
    public void delete(Long id) {
        this.clientRepository.deleteById(id);
    }

    private Address searchAddress(Client client) {
        String zipCode = client.getAddress().getZipCode();

        // Check if Address with this zipCode exists in the repository
        return this.addressRepository.findByZipCode(zipCode)
                .orElseGet(() -> {
                    Address newAddress = this.viaCepService.searchCep(zipCode);
                    if (newAddress != null && newAddress.getZipCode() != null) {
                        return addressRepository.save(newAddress);
                    }
                    return null;
                });
    }

}
