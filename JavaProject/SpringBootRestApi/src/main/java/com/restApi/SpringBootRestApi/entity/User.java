package com.restApi.SpringBootRestApi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "User_details")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long userId;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String mobileNo;
    private String city;
    @NotNull(message = "Password cannot be null")
    private String password;
    @CreationTimestamp
    private LocalDate created_date;

}
