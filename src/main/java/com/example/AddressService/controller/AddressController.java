package com.example.AddressService.controller;

import com.example.AddressService.dto.AddressDto;
import com.example.AddressService.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{id}")
    public ResponseEntity<?> getAddressByEmployeeId(@PathVariable Long id){

        AddressDto addressDto = addressService.getAddressByEmployeeId(id);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }
}
