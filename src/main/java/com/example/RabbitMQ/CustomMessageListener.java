package com.example.RabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CustomMessageListener {

    private static final Logger log = LoggerFactory.getLogger(CustomMessageListener.class);

    @RabbitListener(queues = RabbitMqApplication.QUEUE_GENERIC_NAME)
    public void receiveMessage(final Message message) {
    	System.out.println(message.toString());
     //   log.info("Received message as generic: {}", message.toString());
    }

    @RabbitListener(queues = RabbitMqApplication.QUEUE_SPECIFIC_NAME)
    public void receiveMessage(final CustomMessage customMessage) {
    	System.out.println(customMessage.toString());
     //   log.info("Received message as specific class: {}", customMessage.toString());
    }
}
