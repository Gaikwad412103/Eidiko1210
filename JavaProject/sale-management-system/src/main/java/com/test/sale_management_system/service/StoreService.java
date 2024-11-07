package com.test.sale_management_system.service;

import com.test.sale_management_system.entity.Store;

import java.util.List;

public interface StoreService {
    public Store addStore(Store store);

    public List<Store> fetchAllStores();
}
