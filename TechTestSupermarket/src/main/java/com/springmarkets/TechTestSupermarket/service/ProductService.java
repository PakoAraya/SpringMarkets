package com.springmarkets.TechTestSupermarket.service;

import com.springmarkets.TechTestSupermarket.dto.ProductDTO;
import com.springmarkets.TechTestSupermarket.mapper.Mapper;
import com.springmarkets.TechTestSupermarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<ProductDTO> getProducts() {
    return productRepository.findAll().stream().map(Mapper::toDTO).toList();
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
