package com.test.sale_management_system.service.implementation;

import com.test.sale_management_system.entity.Store;
import com.test.sale_management_system.repository.StoreRepository;
import com.test.sale_management_system.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImp implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Store addStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public List<Store> fetchAllStores() {
        return storeRepository.findAll();
    }
}
