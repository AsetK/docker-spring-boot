package com.epam.docker.springbootdocker.boundary;


import com.epam.docker.springbootdocker.control.PersonRepositoryService;
import com.epam.docker.springbootdocker.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonEndpoint {

    @Autowired
    PersonRepositoryService service;

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Person> personJSON (){
        return service.findAll();
    }

    @GetMapping(value = "/pageable", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Person> personPage (@PageableDefault(size = 1) Pageable pageable ){
        return service.findAll(pageable);
    }

    @PostMapping(value = "/save")
    public Person save(){
        return service.save(new Person("K", "K"));
    }

    @PostMapping(value = "/savejson")
    public Person saveJSON(@RequestBody Person person){
        return service.save(person);
    }

    @GetMapping(value = "/ok")
    public String ok (){
        return "OK";
    }


}
