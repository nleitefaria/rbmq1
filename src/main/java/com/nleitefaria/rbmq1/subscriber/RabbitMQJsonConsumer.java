package com.nleitefaria.rbmq1.subscriber;

import com.nleitefaria.rbmq1.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consumeJsonMessage(User user) {

        LOGGER.info(String.format("Received JSON message -> %s", user.toString()));
        LOGGER.info(String.format("id -> %s", user.getId()));
        LOGGER.info(String.format("FirstName -> %s", user.getFirstName()));
        LOGGER.info(String.format("LastName -> %s", user.getLastName()));

    }

}