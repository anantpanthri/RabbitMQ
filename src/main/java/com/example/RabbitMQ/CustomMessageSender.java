package com.example.RabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CustomMessageSender {

	@Autowired
	private CarRepo carRepo;
	
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public CustomMessageSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 30L)
    public void sendMessage() {
    	int randomNumber=new Random().nextInt(23);
        final CustomMessage message = carRepo.findById(randomNumber);
        System.out.println("sending messages");
        rabbitTemplate.convertAndSend(RabbitMqApplication.EXCHANGE_NAME, RabbitMqApplication.ROUTING_KEY, message);
    }
}
