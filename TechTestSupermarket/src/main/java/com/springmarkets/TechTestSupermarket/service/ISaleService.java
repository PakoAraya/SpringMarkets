package com.springmarkets.TechTestSupermarket.service;

import com.springmarkets.TechTestSupermarket.dto.SaleDTO;

import java.util.List;

public interface ISaleService {
  List<SaleDTO> getSales();
  SaleDTO setSale(SaleDTO saleDTO);
  SaleDTO updateSale(Long id, SaleDTO saleDTO);
  void deleteSale(Long id);
}
