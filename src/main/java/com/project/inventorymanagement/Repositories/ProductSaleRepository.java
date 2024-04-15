package com.project.inventorymanagement.Repositories;

import com.project.inventorymanagement.DTOs.ProductSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSaleRepository extends JpaRepository<ProductSale,Long> {
}
