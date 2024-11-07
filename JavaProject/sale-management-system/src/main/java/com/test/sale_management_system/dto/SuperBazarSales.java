package com.test.sale_management_system.dto;

import lombok.Data;

@Data
public class SuperBazarSales {

    private String productName;
    private int saleQuantity;
    private int mrp;
    private int amount;
}
