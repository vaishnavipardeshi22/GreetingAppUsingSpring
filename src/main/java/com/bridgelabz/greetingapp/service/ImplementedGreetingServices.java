package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ImplementedGreetingServices implements InterfaceGreetingService {

    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello, %s!";


    @Autowired
    GreetingRepository greetingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        Greeting greeting = modelMapper.map(new Greeting(counter.incrementAndGet(), message), Greeting.class);
        return greetingRepository.save(greeting);
    }

    @Override
    public Greeting getGreeting(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public Greeting getUpdateGreeting(long id, String name) {
        String message = String.format(template, name);
        Optional<Greeting> idCheck = greetingRepository.findById(id);
        if (idCheck.isPresent()) {
            idCheck.get().setMessage(message);
            return greetingRepository.save(idCheck.get());
        }
        return null;
    }

    @Override
    public void getDeleteGreeting(long id) {
        Optional<Greeting> idCheck = greetingRepository.findById(id);
        if (idCheck.isPresent()) greetingRepository.deleteById(id);
    }

    @Override
    public List<Greeting> getAllGreeting() {
        return greetingRepository.findAll();
    }
}
