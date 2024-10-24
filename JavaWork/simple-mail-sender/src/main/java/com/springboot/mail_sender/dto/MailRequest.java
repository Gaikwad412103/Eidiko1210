package com.springboot.mail_sender.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailRequest {
    @NotBlank
    private String to;
    @NotBlank
    private String subject;
    @NotBlank
    private String body;
}
