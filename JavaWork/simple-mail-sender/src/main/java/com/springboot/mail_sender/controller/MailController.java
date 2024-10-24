package com.springboot.mail_sender.controller;

import com.springboot.mail_sender.dto.MailRequest;
import com.springboot.mail_sender.service.MailSenderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    @Autowired
    private MailSenderService mailSenderService;

//    @GetMapping("/sendMail")
//    public String sendMail(){
//        try{
//            mailSenderService.sendMail("gaikwadavinash308@gmail.com","Testing Spring Boot Mail Sender","Hello Avinash");
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("Error :"+e.getMessage());
//        }
//        return "Sent Successfully!!";
//    }

    @GetMapping("/sendMail")
    public String sendMail(@RequestBody @Valid MailRequest request){
        try{
            mailSenderService.sendMail(request);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error :"+e.getMessage());
        }
        return "Sent Successfully!!";
    }
}
