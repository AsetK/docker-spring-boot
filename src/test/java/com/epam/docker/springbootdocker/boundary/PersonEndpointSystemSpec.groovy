package com.epam.docker.springbootdocker.boundary

import groovy.json.JsonSlurper
import org.springframework.http.HttpStatus

//resolve spock-spring dependency for autowire beans

class PersonEndpointSystemSpec extends AbstractSystemSpec {

    def "all persons"() {

        given:
        def url = "http://localhost:8085/json"
        def expected = new JsonSlurper().parseText("""
[
    {
        "personID": 1,
        "firstName": "A"
    },
    {
        "personID": 2,
        "firstName": "A"
    },
    {
        "personID": 3,
        "firstName": "B"
    },
    {
        "personID": 4,
        "firstName": "B"
    },
    {
        "personID": 5,
        "firstName": "L"
    }
]
""")

        when:
        def response = restTemplate.getForEntity(url, String.class)

        then:
        response.statusCode == HttpStatus.OK

        def parsedResponse = new JsonSlurper().parseText(response.body)
        expected == parsedResponse
    }
}
