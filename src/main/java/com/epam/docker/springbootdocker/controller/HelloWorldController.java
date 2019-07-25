package com.epam.docker.springbootdocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/docker/hello")
public class HelloWorldController {

    @GetMapping
    public String hello(){
        return "Hello Docker World";
    }
}
