package com.example.UserManagementSystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserManagementSystemBeansBag {
    @Bean
    public List<UserManagementSystem> getDataSource(){
        return new ArrayList<>();
    }

}
