package com.study.design_patterns.controller;

import com.study.design_patterns.model.Client;
import com.study.design_patterns.service.ClientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientServiceInterface service;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Client> searchAll(){
        return this.service.searchAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Client> findById(@PathVariable("id")Long id){
        return this.service.findyById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public Client insert(@RequestBody Client client){

       return this.service.create(client);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client update(@PathVariable("id") Long id, @RequestBody Client client){
        return this.service.update(id, client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        this.service.delete(id);
    }
}
