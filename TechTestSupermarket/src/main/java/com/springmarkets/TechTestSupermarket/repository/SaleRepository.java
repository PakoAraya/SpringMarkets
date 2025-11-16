package com.springmarkets.TechTestSupermarket.repository;

import com.springmarkets.TechTestSupermarket.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
  
}
