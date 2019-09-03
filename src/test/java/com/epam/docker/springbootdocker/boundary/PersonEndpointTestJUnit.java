package com.epam.docker.springbootdocker.boundary;

import com.epam.docker.springbootdocker.SpringBootDockerApplication;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootDockerApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonEndpointTestJUnit {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void findAllPersons(){
        String url = "/json";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        response.getBody();

        assertEquals(response.getStatusCode(), HttpStatus.OK);

        String actual = response.getBody();
        String expected = "[{\"personID\":1,\"firstName\":\"A\"},{\"personID\":2,\"firstName\":\"A\"},{\"personID\":3,\"firstName\":\"B\"},{\"personID\":4,\"firstName\":\"B\"},{\"personID\":5,\"firstName\":\"L\"}]";
        assertEquals(expected, actual);
    }

    @Test

    public void ok(){
        String url = "/ok";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);

    }
}
