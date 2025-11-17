package com.springmarkets.TechTestSupermarket.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //Sale
  @ManyToOne
  private Sale sale;

  //Product
  @ManyToOne
  private Product product;
  private Integer prodQuantity;
  private BigDecimal unitPrice;
}
