package com.test.sale_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleRequest {
    private int id;
    private int productId;
    private int saleQuantity;
    private int storeId;
}
