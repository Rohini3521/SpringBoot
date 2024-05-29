package com.rohini.notification.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final JavaMailSender mailSender;

    @Autowired
    public NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendOtpNotification(String otp) {
        sendEmail(otp);
    }

    private void sendEmail(String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("rohimathapati3521@gmail.com");
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + otp);
        mailSender.send(message);
    }
}
