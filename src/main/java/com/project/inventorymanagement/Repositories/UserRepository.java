package com.project.inventorymanagement.Repositories;

import com.project.inventorymanagement.DTOs.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
