package com.example.neo4jforshiji.entitiy;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@NodeEntity
@RelationshipEntity(type = "relation")
public class PersonRelation {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Person from;

    @Property
    private String relation;

    @EndNode
    private Person to;
}
