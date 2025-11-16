package com.springmarkets.TechTestSupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetailDTO {
  private Long id;
  private String productName;
  private Integer roductQuantity;
  private Double productPrice;
  private Double subTotal;
}
