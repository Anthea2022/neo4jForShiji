package com.example.neo4jforshiji.Service;

import com.example.neo4jforshiji.dao.PersonRelationRepository;
import com.example.neo4jforshiji.dao.PersonRepository;
import com.example.neo4jforshiji.entitiy.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonRelationRepository personRelationRepository;

    public boolean addPerson(Person person){
        if(personRepository.addPerson(person) == 1) {
            return true;
        }
        return false;
    }

    public Person findByName(String name) {
        return personRepository.findByName(name);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public boolean deleteByName(String name) {
        if(personRepository.deleteByName(name) == 1) {
            return true;
        }
        return false;
    }

    public boolean createRelation(String from, String to, String relation) {
        if(personRelationRepository.createPersonRelation(from, to ,relation) == 1) {
            return true;
        }
        return false;
    }
}
