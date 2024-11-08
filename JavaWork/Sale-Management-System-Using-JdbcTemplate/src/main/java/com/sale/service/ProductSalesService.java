package com.sale.service;

import com.sale.dao.ProductSalesDao;
import com.sale.dto.ProductSalesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSalesService {

    @Autowired
    private ProductSalesDao productSalesDao;

    public List<ProductSalesDto> getSuperBazarSales() {
        return productSalesDao.getSuperBazarSales();
    }
}
