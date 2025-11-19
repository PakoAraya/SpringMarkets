package com.springmarkets.TechTestSupermarket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SaleDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //Sale
  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn(name = "saleId")
  private Sale sale;

  //Product
  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn(name = "productId")
  private Product product;
  private Integer prodQuantity;
  private BigDecimal unitPrice;
}
