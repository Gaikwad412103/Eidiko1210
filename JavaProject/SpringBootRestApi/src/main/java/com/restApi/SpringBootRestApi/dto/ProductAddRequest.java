package com.restApi.SpringBootRestApi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.AliasFor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAddRequest {
    private String name;
    private String productType;
    private String productDetails;
    private double price;
}
