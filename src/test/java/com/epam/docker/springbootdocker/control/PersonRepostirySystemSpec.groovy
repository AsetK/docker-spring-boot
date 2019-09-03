package com.epam.docker.springbootdocker.control

import com.epam.docker.springbootdocker.boundary.AbstractSystemSpec
import com.epam.docker.springbootdocker.control.PersonRepository
import org.springframework.beans.factory.annotation.Autowired

import javax.transaction.Transactional

@Transactional
class PersonRepostirySystemSpec extends AbstractSystemSpec {

    @Autowired
    PersonRepository personRepository;

    def "all persons"() {
        given:
        def expectedSize = 5

        when:
        def persons = personRepository.findAll()
        def actualSize = persons.size()

        then:
        expectedSize == actualSize

    }


}
