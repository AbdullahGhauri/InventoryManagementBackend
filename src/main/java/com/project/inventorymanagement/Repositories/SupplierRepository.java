package com.project.inventorymanagement.Repositories;

import com.project.inventorymanagement.DTOs.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
