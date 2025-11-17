package com.springmarkets.TechTestSupermarket.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
  private Long id;
  private String name;
  private String category;
  private Double price;
  private int quantity;
}
