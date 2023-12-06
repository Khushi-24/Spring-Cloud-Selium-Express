package com.example.EmployeeService.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    public ModelMapper returnBean(){
        return new ModelMapper();
    }
}
