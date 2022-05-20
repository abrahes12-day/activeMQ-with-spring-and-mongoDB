package com.activemq.activemqproject.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Document(collection = "testActiveMQ")
public class DataMessage implements Serializable {
   
    @Id
    private String id;
    private String message;
    
}
