package com.test.sale_management_system.service.implementation;

import com.test.sale_management_system.dto.SaleRequest;
import com.test.sale_management_system.dto.SuperBazarSales;
import com.test.sale_management_system.entity.Product;
import com.test.sale_management_system.entity.Sale;
import com.test.sale_management_system.entity.Store;
import com.test.sale_management_system.repository.ProductRepository;
import com.test.sale_management_system.repository.SaleRepository;
import com.test.sale_management_system.repository.StoreRepository;
import com.test.sale_management_system.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
@Service
public class SaleServiceImp implements SaleService {


    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StoreRepository storeRepository;

    public Sale addSales(SaleRequest saleRequest) {
        Product product = productRepository.findById(saleRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Store store = storeRepository.findById(saleRequest.getStoreId())
                .orElseThrow(() -> new RuntimeException("Store not found"));

        Sale sale = new Sale();
        sale.setId(saleRequest.getId());
        sale.setProduct(product);
        sale.setSaleQuantity(saleRequest.getSaleQuantity());
        sale.setStore(store);
        return saleRepository.save(sale);
    }

    @Override
    public List<Object[]> getSuperBazarSales() {
        return saleRepository.findSuperBazarSales();
    }

    @Override
    public List<Sale> fetchAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public List<Object[]> getSaleByStoreName(String storeName) {
        return saleRepository.findSalesByStoreName(storeName);
    }

    @Override
    public List<Object[]> getSaleByStoreId(int id) {
        return saleRepository.findSalesByStoreId(id);
    }

    @Override
    public List<SuperBazarSales> getSalesById(int id) {
        Store store = storeRepository.findById(id).orElseThrow(() -> new RuntimeException("Store not found"));
        List<Product> productList = productRepository.findAll();
        List<Sale> saleList = saleRepository.findAll();
        List<SuperBazarSales> superBazarSales = new ArrayList<>();
        for (Product product : productList) {
            SuperBazarSales bazarSales = new SuperBazarSales();
            bazarSales.setProductName(product.getName());
            bazarSales.setMrp(product.getMrp());
            int count = 0;
            for (Sale sale : saleList) {
                if (sale.getProduct().getId() == product.getId() && sale.getStore().getId() == id) {
                    count = count + sale.getSaleQuantity();
                }
            }
            bazarSales.setSaleQuantity(count);
            bazarSales.setAmount(count * product.getMrp());
            superBazarSales.add(bazarSales);
        }
        return superBazarSales;
    }
}

