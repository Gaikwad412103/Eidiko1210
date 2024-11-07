package com.test.sale_management_system.service;

import com.test.sale_management_system.dto.SaleRequest;
import com.test.sale_management_system.dto.SuperBazarSales;
import com.test.sale_management_system.entity.Sale;

import java.util.List;

public interface SaleService {
    public Sale addSales(SaleRequest saleRequest);
    public List<Object[]> getSuperBazarSales();

    public List<Sale> fetchAllSales();

    public List<Object[]> getSaleByStoreName(String storeName);

    public List<Object[]> getSaleByStoreId(int id);

    List<SuperBazarSales> getSalesById(int id);
}
