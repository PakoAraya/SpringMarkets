package com.springmarkets.TechTestSupermarket.service;

import com.springmarkets.TechTestSupermarket.dto.ProductDTO;
import com.springmarkets.TechTestSupermarket.exception.NotFoundException;
import com.springmarkets.TechTestSupermarket.mapper.Mapper;
import com.springmarkets.TechTestSupermarket.model.Product;
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
    return productRepository.findAll()
            .stream()
            .map(Mapper::toDTO)
            .toList();
  }

  @Override
  public ProductDTO setProduct(ProductDTO productDTO) {
    Product prod = Product.builder()
            .name(productDTO.getName())
            .category(productDTO.getCategory())
            .price(productDTO.getPrice())
            .quantity(productDTO.getQuantity())
            .build();
    return Mapper.toDTO(productRepository.save(prod));
  }

  @Override
  public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
    //First step search product data on database by id
    Product prod = productRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Product Not Found"));

    prod.setName(productDTO.getName());
    prod.setCategory(productDTO.getCategory());
    prod.setPrice(productDTO.getPrice());
    prod.setQuantity(productDTO.getQuantity());

    return Mapper.toDTO(productRepository.save(prod));
  }

  @Override
  public void deleteProduct(Long id) {
    if(!productRepository.existsById(id)){
      throw new NotFoundException("Product not found. Deletion cannot be completed with id: " + id);
    }
    productRepository.deleteById(id);
  }
}
