package com.test.sale_management_system.controller;

import com.test.sale_management_system.entity.Store;
import com.test.sale_management_system.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/addStore")
    public Store addStore(@RequestBody Store store){
        return storeService.addStore(store);
    }

    @GetMapping("/getAllStores")
    public List<Store> fetchAllStore(){
        return storeService.fetchAllStores();
    }
}
