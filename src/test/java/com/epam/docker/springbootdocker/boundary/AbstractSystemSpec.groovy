package com.epam.docker.springbootdocker.boundary

import com.epam.docker.springbootdocker.SpringBootDockerApplication
import com.epam.docker.springbootdocker.control.PersonRepository
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

@SpringBootTest(classes = [ SpringBootDockerApplication.class],webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class AbstractSystemSpec extends Specification {

    @Autowired
    TestRestTemplate restTemplate;

}
