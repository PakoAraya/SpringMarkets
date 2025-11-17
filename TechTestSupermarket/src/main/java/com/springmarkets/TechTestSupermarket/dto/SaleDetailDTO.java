package com.springmarkets.TechTestSupermarket.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDetailDTO {
  private Long id;
  private String productName;
  private Integer productQuantity;
  private BigDecimal productPrice;
  private BigDecimal subTotal;
}
