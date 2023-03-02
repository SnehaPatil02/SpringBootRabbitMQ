package com.springboot.rabbitMQ.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.springboot.rabbitMQ.dto.User;

@Service
public class JsonConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonConsumer.class);

	//The @RabbitListener will trigger a logic inside Spring to find a converter from JSON to that specific class.
    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(User user){
        LOGGER.info(String.format("Received JSON message -> %s", user.toString()));
    }
}
