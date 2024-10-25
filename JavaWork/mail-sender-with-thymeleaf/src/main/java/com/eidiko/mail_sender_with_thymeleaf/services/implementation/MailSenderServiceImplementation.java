package com.eidiko.mail_sender_with_thymeleaf.services.implementation;

import com.eidiko.mail_sender_with_thymeleaf.dto.MailRequest;
import com.eidiko.mail_sender_with_thymeleaf.services.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderServiceImplementation implements MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String SendMail(MailRequest mailRequest) {
        try {
            SimpleMailMessage message=new SimpleMailMessage();
            message.setTo(mailRequest.getTo());
            message.setSubject(mailRequest.getSubject());
            message.setText(mailRequest.getBody());
            javaMailSender.send(message);
        } catch (MailException e) {
            return "error";
        }
        return "success";
    }
}
