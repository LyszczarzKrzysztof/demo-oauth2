package com.example.demooauth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {

    @GetMapping("api/hello")
    public String sayHello(){
        return "hello";
    }
}
