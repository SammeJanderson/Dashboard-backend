package com.sammjanderson.PerkProgramApi.repository;

import com.sammjanderson.PerkProgramApi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
