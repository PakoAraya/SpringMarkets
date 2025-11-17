package com.springmarkets.TechTestSupermarket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDate date;
  private String status;
  private BigDecimal total;

  //Relationship with the store
  @ManyToOne
  private Store store;

  //Relationship with the sale details
  @OneToMany(mappedBy = "sale")
  private List<SaleDetail> saleDetails = new ArrayList<>();
}
