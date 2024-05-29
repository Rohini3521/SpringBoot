package com.rohini.notification.email;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OTPProducer implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @Autowired
    public OTPProducer(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    @Override
    public void run(String... args) throws Exception {
        String otp = "123456";
        rabbitTemplate.convertAndSend(this.queue.getName(), otp);
        System.out.println("OTP sent: " + otp);
    }
}
