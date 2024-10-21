package com.restApi.SpringBootRestApi.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private long userId;
    @NotNull(message = "First name cannot be null")
    private String firstName;
    private String lastName;
    @Email(message = "Email is not valid!!")
    private String email;
    @Pattern(regexp = "^\\d{10}$",message = "mobile no is not valid")
    private String mobileNo;
    private String city;
    @CreationTimestamp
    private LocalDate created_date;
    private String token;
}
