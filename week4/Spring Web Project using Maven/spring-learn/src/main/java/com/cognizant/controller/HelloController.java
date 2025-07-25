package com.cognizant.controller;

import com.cognizant.model.Message;
import com.cognizant.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public Message hello() {
        return helloService.getHelloMessage();
    }
}
