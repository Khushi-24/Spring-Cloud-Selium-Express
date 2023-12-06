package com.example.EmployeeService.config;

import com.example.EmployeeService.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address-service",url= "http://localhost:8080")
public interface AddressConfig {

    @GetMapping("/address/{id}")
    public AddressDto addressDto(@PathVariable Long id);
}
