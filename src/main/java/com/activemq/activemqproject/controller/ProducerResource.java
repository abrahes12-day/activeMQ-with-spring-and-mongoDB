package com.activemq.activemqproject.controller;


import javax.jms.Queue;

import com.activemq.activemqproject.model.DataMessage;
import com.activemq.activemqproject.repository.DataMessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
//import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProducerResource {
    
    @Autowired
    private DataMessageRepository dataMessageRepository;

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;

    @PostMapping("/activeMQ/send-message")
    public ResponseEntity<Object> dataMessage(@RequestBody DataMessage message) {
        DataMessage sendMessage = new DataMessage();
        sendMessage.setMessage(message.toString());
        DataMessage savedMessage = this.dataMessageRepository.save(message);

        //byte[] byteMessage = SerializationUtils.serialize(savedMessage);

        jmsTemplate.convertAndSend(queue, savedMessage.toString());
        return new ResponseEntity<Object>("Publish Successfully...", HttpStatus.OK);
    }

}
