package com.springmarkets.TechTestSupermarket.controller;


import com.springmarkets.TechTestSupermarket.dto.ProductDTO;
import com.springmarkets.TechTestSupermarket.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private IProductService productService;

  @GetMapping
  public ResponseEntity<List<ProductDTO>> getProducts(){
   return ResponseEntity.ok(productService.getProducts());
  }

   @PostMapping
   public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
    /* One way to implement
    return ResponseEntity.ok(productService.setProduct(productDTO)); */
     ProductDTO create = productService.setProduct(productDTO);
     return ResponseEntity.created(URI.create("/api/products " + create.getId())).body(create);

   }

   @PutMapping("/{id}")
   public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id,
                                                   @RequestBody ProductDTO productDTO){
      return ResponseEntity.ok(productService.updateProduct(id, productDTO));
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
      productService.deleteProduct(id);
      return ResponseEntity.noContent().build();
   }
}
