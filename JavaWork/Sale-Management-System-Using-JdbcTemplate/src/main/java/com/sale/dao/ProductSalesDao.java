package com.sale.dao;

import com.sale.dto.ProductSalesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductSalesDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ProductSalesDto mapRowToProductSales(ResultSet rs, int rowNum) throws SQLException {
        return new ProductSalesDto(
                rs.getString("product_name"),
                rs.getInt("sale"),
                rs.getDouble("mrp"),
                rs.getDouble("amount")
        );
    }

    public List<ProductSalesDto> getSuperBazarSales() {
        String sql = "SELECT p.name AS product_name, " +
                "COALESCE(SUM(s.sale_quantity), 0) AS sale, " +
                "p.mrp, " +
                "COALESCE(SUM(s.sale_quantity) * p.mrp, 0) AS amount " +
                "FROM product p " +
                "LEFT JOIN sale s ON p.id = s.product_id " +
                "AND s.store_id = (SELECT id FROM store WHERE name = 'super bazar') " +
                "GROUP BY p.id, p.name, p.mrp";

        return jdbcTemplate.query(sql, this::mapRowToProductSales);
    }
}
