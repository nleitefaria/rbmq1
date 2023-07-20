package com.nleitefaria.rbmq1.controller;

import com.nleitefaria.rbmq1.dto.User;
import com.nleitefaria.rbmq1.publisher.RabbitMQJsonProducer;
import com.nleitefaria.rbmq1.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducer producer;

    private RabbitMQJsonProducer jsonProducer;

    public MessageController(RabbitMQProducer producer, RabbitMQJsonProducer jsonProducer) {

        this.producer = producer;
        this.jsonProducer = jsonProducer;

    }

    // http://localhost:8080/api/v1/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ ...");
    }
}