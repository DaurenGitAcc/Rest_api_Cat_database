package com.absattarov.PostgreSql_REST.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Setter
@Getter
@Document
public class Dog {

    @Id
    private UUID id;
    @Indexed(unique = true)
    private String name;
    private int age;

}
