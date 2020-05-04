package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

import java.util.List;

public interface InterfaceGreetingService {
    Greeting getGreeting(long id);

    Greeting addGreeting(User user);

    Greeting getUpdateGreeting(long id, String name);

    void getDeleteGreeting(long id);

    List<Greeting> getAllGreeting();
}
