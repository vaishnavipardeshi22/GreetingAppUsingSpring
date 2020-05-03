package com.bridgelabz.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class IGreetingServices implements GreetingService {

    @Override
    public String getGreeting(String... name) {
        if (name.length == 2) return "Hello " + name[0] + " " + name[1];
        if (name.length == 1) return "Hello " + name[0];
        return "Hello World";
    }
}
