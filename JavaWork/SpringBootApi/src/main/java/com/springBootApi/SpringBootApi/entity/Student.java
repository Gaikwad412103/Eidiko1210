package com.springBootApi.SpringBootApi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name ="student_details")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotEmpty(message = "Name Cannot Be Empty!!")
    @Size(min = 2)
    private String firstName;
    private String lastName;
    private String city;
    @Column(nullable = false)
    @NotEmpty(message = "Mobile No Cannot Be Empty")
    @Pattern(regexp = "^\\d{10}$")
    private String mobileNo;

}
