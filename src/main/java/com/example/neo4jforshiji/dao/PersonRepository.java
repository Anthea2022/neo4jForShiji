package com.example.neo4jforshiji.dao;

import com.example.neo4jforshiji.entitiy.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends Neo4jRepository<Person,Long> {

    /**
     * 查询所有人
     * @return
     */
    @Query("match (n:Person) RETURN n")
    public List<Person> findAll();

    /**
     * 查询姓名
     * @param name
     * @return
     */
    @Query("match (n:Person {name:$name}) RETURN n")
    public Person findByName(String name);


    /**
     * 创建人物
     * @param person
     */
    @Query("create (n:Person {name:$name}) RETURN 1")
    public int addPerson(@Param("person") Person person);

    @Query("match (n:Person) where n.name = $name delete n RETURN 1")
    public int deleteByName(String name);
}
