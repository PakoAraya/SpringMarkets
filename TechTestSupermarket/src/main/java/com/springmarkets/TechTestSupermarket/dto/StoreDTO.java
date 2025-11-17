package com.springmarkets.TechTestSupermarket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreDTO {
  private Long id;
  private String name;
  private String address;
}
