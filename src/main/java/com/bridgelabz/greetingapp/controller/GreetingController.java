package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingService greetingService;

    @RequestMapping("/greeting")
    public String greeting() {
        return greetingService.getGreeting();
    }
    @GetMapping("/param/greeting")
    public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), greetingService.getGreeting(name));
    }

    @GetMapping("/greeting")
    public Greeting getGreeting() {
        return new Greeting(counter.incrementAndGet(), greetingService.getGreeting());
    }

    @PostMapping("/post")
    public Greeting postGreeting(@RequestBody User user) {
        return new Greeting(counter.incrementAndGet(), greetingService.getGreeting(user.getFirstName(), user.getLastName()));
    }

    @PutMapping("/put")
    public Greeting putGreeting(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return new Greeting(counter.incrementAndGet(), greetingService.getGreeting(firstName, lastName));
    }
}
