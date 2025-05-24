package com.bhavika.budget_brains.controller;


import com.bhavika.budget_brains.DTO.LeadRequest;
import com.bhavika.budget_brains.service.LeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/contact")
@CrossOrigin(origins = "https://www.budgetandbrains.com")
public class AuditController {

    @Autowired
    private LeadsService leadsService;

    @PostMapping("/submit")
    public String submitContactForm(@RequestBody LeadRequest request) {
        leadsService.processContactForm(request);
        return "Contact form submitted successfully!";
    }
}
