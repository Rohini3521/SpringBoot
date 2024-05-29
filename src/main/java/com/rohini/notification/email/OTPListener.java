package com.rohini.notification.email;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class OTPListener {

    private static final Logger logger = LoggerFactory.getLogger(OTPListener.class);
    private final NotificationService notificationService;

    public OTPListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "otpQueue")
    public void listen(String otp) {
        try {
            System.out.println("Received OTP: " + otp);
            notificationService.sendOtpNotification(otp);
        } catch (Exception e) {
            logger.error("Error processing message", e);
        }
    }
}