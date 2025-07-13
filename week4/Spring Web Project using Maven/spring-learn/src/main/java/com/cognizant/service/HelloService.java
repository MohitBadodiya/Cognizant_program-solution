package com.cognizant.service;

import com.cognizant.model.Message;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public Message getHelloMessage() {
        return new Message("Hello from Spring Boot Service!");
    }
}
