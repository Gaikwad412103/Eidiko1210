package com.restApi.SpringBootRestApi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    @Email(message = "Email is not valid!!")
    @NotBlank(message = "Email should be mandatory")
    private String email;
    @Pattern(regexp = "^\\d{10}$",message = "mobile no is not valid")
    @NotNull
    private String mobileNo;
    private String roles;
    private String city;
    @NotBlank(message = "Password Should Be Mandatory")
    private String password;
}
