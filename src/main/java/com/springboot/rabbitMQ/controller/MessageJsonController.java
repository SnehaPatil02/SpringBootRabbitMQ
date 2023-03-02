package com.springboot.rabbitMQ.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rabbitMQ.dto.User;
import com.springboot.rabbitMQ.producer.JsonProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
	private JsonProducer jsonProducer;

    public MessageJsonController(JsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ ...");
    }
}
