package com.example.neo4jforshiji.dao;

import com.example.neo4jforshiji.entitiy.PersonRelation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonRelationRepository extends Neo4jRepository<PersonRelation, Long> {

    /**
     * 创建关系
     * @param from
     * @param to
     */
    @Query("match (m:Person),(n:Person) where m.name = $from and n.name = $to " +
    "create (m)-[r:妹妹]->(n) RETURN 1")
    public int createPersonRelation(String from, String to, String relation);
}
