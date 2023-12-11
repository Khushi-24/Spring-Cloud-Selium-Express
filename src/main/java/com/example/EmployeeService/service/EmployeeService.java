package com.example.EmployeeService.service;

import com.example.EmployeeService.config.AddressConfig;
import com.example.EmployeeService.dto.AddressDto;
import com.example.EmployeeService.dto.EmployeeDto;
import com.example.EmployeeService.entity.Employee;
import com.example.EmployeeService.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressConfig addressConfig;

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;


    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public EmployeeDto getEmployeeById(Long id){
        Employee employee = employeeRepo.getById(id);
//        AddressDto addressDto = addressConfig.addressDto(id);

        //There might be more than one instances running of address service
//        List<ServiceInstance> instances = discoveryClient.getInstances("address-service");
//        ServiceInstance serviceInstance = instances.get(0);
        ServiceInstance serviceInstance = loadBalancerClient.choose("address-service");
        String uri = serviceInstance.getUri().toString();
        System.out.println("Url >>>>>>>>>   "+uri);
        AddressDto addressDto =restTemplate.getForObject(uri +"/address/"+id, AddressDto.class);
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        employeeDto.setAddress(addressDto);
        return employeeDto;
    }
}
