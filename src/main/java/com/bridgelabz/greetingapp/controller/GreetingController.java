package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetingController")
public class GreetingController {

    private AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;

    @RequestMapping("/greeting/get/{id}")
    public Greeting greeting(@PathVariable long id) {
        return greetingService.getGreeting(id);
    }

    @GetMapping("/greeting/get/all")
    public List<Greeting> getGreeting() {
        return greetingService.getAllGreeting();
    }

    @PostMapping("/greeting/post")
    public Greeting postGreeting(@RequestBody User user) {
        return greetingService.addGreeting(user);
    }

    @PutMapping("/greeting/put/{id}")
    public Greeting putGreeting(@PathVariable long id, @RequestParam(value = "name") String name) {
        return greetingService.getUpdateGreeting(id, name);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGreeting(@PathVariable long id) {
        greetingService.getDeleteGreeting(id);
    }
}
