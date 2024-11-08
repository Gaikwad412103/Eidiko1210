package com.sale.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    private int productId;
    private int saleQuantity;
    private int storeId;
}
