package com.test.sale_management_system.controller;

import com.test.sale_management_system.dto.SaleRequest;
import com.test.sale_management_system.dto.SuperBazarSales;
import com.test.sale_management_system.entity.Sale;
import com.test.sale_management_system.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleController {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/addSales")
    public Sale addSales(@RequestBody SaleRequest saleRequest){
        return saleService.addSales(saleRequest);
    }

    @GetMapping("/getAllSales")
    public List<Sale> fetchAllSales(){
        return saleService.fetchAllSales();
    }


    @GetMapping("/super-bazar")
    public List<Object[]> getSuperBazarSales() {
        return saleService.getSuperBazarSales();
    }

    @GetMapping("/getSales/{storeName}")
    public List<Object[]> getSaleByStoreName(@PathVariable String storeName){
        return saleService.getSaleByStoreName(storeName);
    }

    @GetMapping("/getSalesById/{id}")
    public List<Object[]> getSaleByStoreId(@PathVariable("id") int id){
        return saleService.getSaleByStoreId(id);
    }
//_________________________________________________

    @GetMapping("/getSales/byId/{id}")
    public List<SuperBazarSales> getSalesById(@PathVariable int id){
        return saleService.getSalesById(id);
    }


}
