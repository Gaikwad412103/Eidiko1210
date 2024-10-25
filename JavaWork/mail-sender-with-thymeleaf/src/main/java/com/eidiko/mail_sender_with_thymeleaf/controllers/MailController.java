package com.eidiko.mail_sender_with_thymeleaf.controllers;



import com.eidiko.mail_sender_with_thymeleaf.dto.MailRequest;
import com.eidiko.mail_sender_with_thymeleaf.services.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {
    @Autowired
    private MailSenderService mailSenderService;

    @GetMapping("/mail")
    public String mail(Model model){
        model.addAttribute("emailRequest",new MailRequest());
        return "mail";
    }

    @PostMapping("/sendEmail")
    public String sendMail(@ModelAttribute("emailRequest") MailRequest mailRequest){
        return mailSenderService.SendMail(mailRequest);
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
