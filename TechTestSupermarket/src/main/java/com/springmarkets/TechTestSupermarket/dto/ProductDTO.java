package com.springmarkets.TechTestSupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
  private Long id;
  private String name;
  private String category;
  private Double price;
  private int quantity;
}
