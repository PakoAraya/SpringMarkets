package com.springmarkets.TechTestSupermarket.repository;

import com.springmarkets.TechTestSupermarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
  //Search Product by Name
  Optional<Product> findByName(String name);
}
