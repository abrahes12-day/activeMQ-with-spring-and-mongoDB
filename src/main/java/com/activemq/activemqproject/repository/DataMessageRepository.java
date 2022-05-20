package com.activemq.activemqproject.repository;

import com.activemq.activemqproject.model.DataMessage;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataMessageRepository extends MongoRepository<DataMessage, String>{
    @SuppressWarnings("unchecked")
    DataMessage save(DataMessage request);
}
