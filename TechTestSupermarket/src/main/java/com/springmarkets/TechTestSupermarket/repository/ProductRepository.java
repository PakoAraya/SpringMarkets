package com.springmarkets.TechTestSupermarket.repository;

import com.springmarkets.TechTestSupermarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
