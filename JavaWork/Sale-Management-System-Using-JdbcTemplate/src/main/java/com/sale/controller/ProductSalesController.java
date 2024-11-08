package com.sale.controller;

import com.sale.dto.ProductSalesDto;
import com.sale.service.ProductSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductSalesController {

    @Autowired
    private ProductSalesService productSalesService;

    @GetMapping("/superBazar")
    public List<ProductSalesDto> getSuperBazarSales() {
        return productSalesService.getSuperBazarSales();
    }
}
