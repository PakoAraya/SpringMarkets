package com.springmarkets.TechTestSupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {
  //Sale Info
  private Long id;
  private LocalDate date;
  private String status;

  //Store Info
  private Long storeId;

  //Details List
  private List<SaleDetailDTO> detail;

  //Total Price
  private Double total;
}
