package com.project.inventorymanagement.Repositories;

import com.project.inventorymanagement.DTOs.ProductSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSupplierRepository extends JpaRepository<ProductSupplier,Long> {
}
