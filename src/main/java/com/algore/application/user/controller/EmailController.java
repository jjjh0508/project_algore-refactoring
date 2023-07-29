package com.algore.application.user.controller;

import com.algore.application.user.config.MailProperties;
import com.algore.application.user.dto.EmailAuthDTO;
import com.algore.application.user.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
public class EmailController {
    private final EmailService emailService;
    private final MailProperties mailProperties;

    public EmailController(EmailService emailService, MailProperties mailProperties) {
        this.emailService = emailService;
        this.mailProperties = mailProperties;
    }

    @PostMapping("/mailConfirm")
    public String mailConfirm(@RequestBody EmailAuthDTO emailAuthDTO) throws MessagingException, UnsupportedEncodingException {
        System.out.println("호출");

        String authCode = emailService.sendEmail(emailAuthDTO.getEmail());


        return authCode;
    }
}
