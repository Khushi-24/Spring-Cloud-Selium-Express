package com.example.EmployeeService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {

    private Long id;

    private String name;

    private String bloodGroup;

    private AddressDto address;
}
