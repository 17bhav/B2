package com.bhavika.budget_brains.service;

import com.bhavika.budget_brains.DTO.LeadRequest;
import com.bhavika.budget_brains.entity.Leads;
import com.bhavika.budget_brains.repository.LeadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LeadsService {



    @Autowired
    private LeadsRepository repository;


    @Autowired
    private EmailService emailService;

    public void processContactForm(LeadRequest request) {
        emailService.sendLeadNotificationEmail(request);
        emailService.sendThankYouEmail(request);

        Leads entity = new Leads();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setMessage(request.getMessage());
        entity.setCompanyName(request.getCompany());
        if(request.getWebsite()!=null){
            entity.setWebsite(request.getWebsite());
        }
        entity.setSubmittedAt(LocalDateTime.now());

        repository.save(entity);
    }
}