package com.epam.docker.springbootdocker.control;


import com.epam.docker.springbootdocker.entity.Person;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTestJUnit {

    @Autowired
    PersonRepository repository;

    @Test
    public void findAll() {
        Iterable<Person> allPerson = repository.findAll();
        List<Person> personList = new ArrayList<>();
        allPerson.forEach(personList::add);

        assertEquals(5, personList.size());
    }
}