package com.bridgelabz.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class IGreetingServices implements GreetingService {

    @Override
    public String getGreeting() {
        return "Hello World";
    }
}
