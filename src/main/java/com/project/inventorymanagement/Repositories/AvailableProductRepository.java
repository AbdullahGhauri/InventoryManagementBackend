package com.project.inventorymanagement.Repositories;

import com.project.inventorymanagement.DTOs.AvailableProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableProductRepository extends JpaRepository<AvailableProduct,Long> {
}
