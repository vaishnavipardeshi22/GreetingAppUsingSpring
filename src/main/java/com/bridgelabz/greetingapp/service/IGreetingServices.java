package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class IGreetingServices implements GreetingService {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Greeting addGreeting(User user) {
        String message = "Hello";
        message = user.toString().isEmpty() ? "Hello World" : user.getFirstName() + " " + user.getLastName();
        Greeting greeting = modelMapper.map(new Greeting(counter.incrementAndGet(), message), Greeting.class);
        return greetingRepository.save(greeting);
    }

    @Override
    public String getGreeting(String... name) {
        if (name.length == 2) return "Hello " + name[0] + " " + name[1];
        if (name.length == 1) return "Hello " + name[0];
        return "Hello World";
    }
}
