package com.springboot.mail_sender.service;

import com.springboot.mail_sender.dto.MailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

//    @Value("spring.mail.username")
//    private String from;

//    public void sendMail(String to,String subject,String body){
//        SimpleMailMessage message=new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(body);
//        message.setFrom(from);
//        javaMailSender.send(message);
//    }

    public void sendMail(MailRequest request){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(request.getTo());
        message.setSubject(request.getSubject());
        message.setText(request.getBody());
        javaMailSender.send(message);
    }
}
