package com.bhavika.budget_brains.service;


import com.bhavika.budget_brains.DTO.LeadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.mail.from}")
    private String fromAddress;

    @Async
    public void sendLeadNotificationEmail(LeadRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(fromAddress);
        message.setSubject("New Lead For Budget and brains ");
        message.setText("Name: " + request.getName() +
                "\nEmail: " + request.getEmail() +
                "\nMessage: " + request.getMessage()+
                "\nPhone number: "+request.getContact());
        message.setFrom(fromAddress);
        mailSender.send(message);
    }

    @Async
    public void sendThankYouEmail(LeadRequest request) {
        SimpleMailMessage message2 = new SimpleMailMessage();
        message2.setTo(request.getEmail());
        message2.setSubject("Thank You For Submitting an Audit with Budget and brains ");
        message2.setText("Name: " + request.getName() +
                "\nEmail: " + request.getEmail() +
                "\nMessage: " + request.getMessage());
        message2.setFrom(fromAddress);
        mailSender.send(message2);
    }
}