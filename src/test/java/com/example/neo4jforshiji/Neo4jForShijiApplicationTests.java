package com.example.neo4jforshiji;

import com.example.neo4jforshiji.dao.PersonRelationRepository;
import com.example.neo4jforshiji.dao.PersonRepository;
import com.example.neo4jforshiji.entitiy.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Neo4jForShijiApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonRelationRepository personRelationRepository;

    @Test
    void test() {
        Person person = personRepository.findByName("吕后");
        System.out.println(person.getName());
    }

}
