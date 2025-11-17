package com.springmarkets.TechTestSupermarket.service;

import com.springmarkets.TechTestSupermarket.dto.ProductDTO;

import java.util.List;

public interface IProductService {
  List<ProductDTO> getProducts();
  ProductDTO setProduct(ProductDTO productDTO);
  ProductDTO updateProduct(Long id, ProductDTO productDTO);
  void deleteProduct(Long id);
}
