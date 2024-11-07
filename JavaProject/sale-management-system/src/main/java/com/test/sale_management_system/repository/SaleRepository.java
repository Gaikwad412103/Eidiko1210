package com.test.sale_management_system.repository;

import com.test.sale_management_system.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Integer> {
    @Query("SELECT p.name, SUM(s.saleQuantity), p.mrp, SUM(s.saleQuantity * p.mrp) " +
            "FROM Sale s JOIN s.product p JOIN s.store st " +
            "WHERE st.name = 'super bazar' " +
            "GROUP BY p.name, p.mrp")
    public List<Object[]> findSuperBazarSales();

    @Query("SELECT p.name, SUM(s.saleQuantity), p.mrp, SUM(s.saleQuantity * p.mrp) " +
            "FROM Sale s JOIN s.product p JOIN s.store st " +
            "WHERE st.name = ?1 " +
            "GROUP BY p.name, p.mrp")
    public List<Object[]> findSalesByStoreName(String storeName);


    @Query("SELECT p.name, SUM(s.saleQuantity), p.mrp, SUM(s.saleQuantity * p.mrp) " +
            "FROM Sale s JOIN s.product p JOIN s.store st " +
            "WHERE st.id = ?1 " +
            "GROUP BY p.name, p.mrp")
    public List<Object[]> findSalesByStoreId(int id);




}
