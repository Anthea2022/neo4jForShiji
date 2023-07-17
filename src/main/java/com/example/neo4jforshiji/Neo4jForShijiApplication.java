package com.example.neo4jforshiji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "com.example.neo4jforshiji.dao")
@EntityScan(basePackages = "com.example.neo4jforshiji.entitiy")
public class Neo4jForShijiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Neo4jForShijiApplication.class, args);
    }

}
