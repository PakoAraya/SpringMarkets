package com.springmarkets.TechTestSupermarket.service;

import com.springmarkets.TechTestSupermarket.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

  @Override
  public List<ProductDTO> getProducts() {
    return List.of();
  }

  @Override
  public ProductDTO setProduct(ProductDTO productDTO) {
    return null;
  }

  @Override
  public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
    return null;
  }

  @Override
  public void deleteProduct(Long id) {

  }
}
