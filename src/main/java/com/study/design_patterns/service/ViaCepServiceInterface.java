package com.study.design_patterns.service;

import com.study.design_patterns.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepServiceInterface {

    @GetMapping("/{zipCode}/json/")
    Address searchCep(@PathVariable("zipCode") String zipCode);
}
