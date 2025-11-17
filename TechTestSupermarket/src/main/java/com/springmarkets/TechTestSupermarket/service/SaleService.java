package com.springmarkets.TechTestSupermarket.service;

import com.springmarkets.TechTestSupermarket.dto.SaleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements ISaleService {

  @Override
  public List<SaleDTO> getSales() {
    return List.of();
  }

  @Override
  public SaleDTO setSale(SaleDTO saleDTO) {
    return null;
  }

  @Override
  public SaleDTO updateSale(Long id, SaleDTO saleDTO) {
    return null;
  }

  @Override
  public void deleteSale(Long id) {

  }
}
