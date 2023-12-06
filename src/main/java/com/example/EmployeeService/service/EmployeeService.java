package com.example.EmployeeService.service;

import com.example.EmployeeService.dto.EmployeeDto;
import com.example.EmployeeService.entity.Employee;
import com.example.EmployeeService.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeDto getEmployeeById(Long id){
        Employee employee = employeeRepo.getById(id);
        return modelMapper.map(employee, EmployeeDto.class);
    }
}
