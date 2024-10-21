package com.restApi.SpringBootRestApi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "User_details", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "mobileNo")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long userId;
    @NotNull(message = "First name cannot be null")
    private String firstName;
    private String lastName;
    @Email(message = "Email is not valid!!")
    @NotBlank(message = "Email should be mandatory")
    private String email;
    @Pattern(regexp = "^\\d{10}$",message = "mobile no is not valid")
    private String mobileNo;
    private String roles;
    private String city;
//    @NotNull(message = "Password cannot be null")
//    @Size(min = 3, max = 16, message = "Password must be between 3 to 16 characters")
    private String password;
    @CreationTimestamp
    private LocalDate created_date;

}
