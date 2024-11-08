package com.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSalesDto {
    private String productName;
    private int sale;
    private double mrp;
    private double amount;
}
