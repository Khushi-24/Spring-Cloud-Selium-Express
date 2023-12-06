package com.example.AddressService.service;


import com.example.AddressService.dto.AddressDto;
import com.example.AddressService.entity.Address;
import com.example.AddressService.repository.AddressRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AddressDto getAddressByEmployeeId(Long id){
        Address address = addressRepo.findByEmpId(id);
        return modelMapper.map(address, AddressDto.class);
    }
}
