package com.example.AddressService.repository;

import com.example.AddressService.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

    Address findByEmpId(Long id);
}

