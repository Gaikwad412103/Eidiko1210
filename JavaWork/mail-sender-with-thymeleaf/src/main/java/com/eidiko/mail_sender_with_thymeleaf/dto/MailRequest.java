package com.eidiko.mail_sender_with_thymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailRequest {
    private String to;
    private String subject;
    private String body;


}
