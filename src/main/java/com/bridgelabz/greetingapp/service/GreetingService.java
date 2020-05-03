package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

public interface GreetingService {
    String getGreeting(String... name);

    Greeting addGreeting(User user);
}
