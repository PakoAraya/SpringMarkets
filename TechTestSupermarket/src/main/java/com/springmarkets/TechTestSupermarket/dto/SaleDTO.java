package com.springmarkets.TechTestSupermarket.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
  private BigDecimal total;
}
