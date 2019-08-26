package com.epam.docker.springbootdocker.control;

import com.epam.docker.springbootdocker.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonRepositoryService {

    private final PersonRepository personRepository;

    public Page<Person> findAll(Pageable pageable){
        return personRepository.findAll(pageable);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person save(Person person){
        return personRepository.save(person);
    }


}
