package com.eidiko.mail_sender_with_thymeleaf.services;

import com.eidiko.mail_sender_with_thymeleaf.dto.MailRequest;

public interface MailSenderService {

    public String SendMail(MailRequest mailRequest);
}
