package com.restApi.SpringBootRestApi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Currency;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank(message = "Empty name is not allowed")
    @NotNull(message = "Null name is not allowed")
    private String name;
    private String productType;
    private String productDetails;
    @Min(0)
    private double price;
    @CreationTimestamp
    private LocalDate created_date;
}
