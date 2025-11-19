package com.springmarkets.TechTestSupermarket.mapper;


import com.springmarkets.TechTestSupermarket.dto.ProductDTO;
import com.springmarkets.TechTestSupermarket.dto.SaleDTO;
import com.springmarkets.TechTestSupermarket.dto.SaleDetailDTO;
import com.springmarkets.TechTestSupermarket.dto.StoreDTO;
import com.springmarkets.TechTestSupermarket.model.Product;
import com.springmarkets.TechTestSupermarket.model.Sale;
import com.springmarkets.TechTestSupermarket.model.Store;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;


public class Mapper {

  //Mapping from Product to ProductDTO
  public static ProductDTO toDTO(Product p){
    if(p == null) return null;

    return ProductDTO.builder()
            .id(p.getId())
            .name(p.getName())
            .category(p.getCategory())
            .price(p.getPrice())
            .quantity(p.getQuantity())
            .build();
  }

  //Mapping from Sale to SaleDTO
  public static SaleDTO toDTO(Sale sale){
    if (sale == null) return null;

    var detailList = sale.getSaleDetails().stream()
            .map(det -> SaleDetailDTO.builder()
                    .id(det.getProduct().getId())
                    .productName(det.getProduct().getName())
                    .productQuantity(det.getProdQuantity())
                    .productPrice(det.getUnitPrice())
                    //.subTotal Work in professional best practices
                    //subtotal(det.getUnitPrice() * det.getProdQuantity()) In case to use Double at price
                    .subTotal(
                            det.getUnitPrice()
                                    .multiply(BigDecimal.valueOf(det.getProdQuantity()))
                                    .setScale(2, RoundingMode.HALF_UP)
                    )
                    .build()
            )
            .collect(Collectors.toList());

    var total = detailList.stream()
            .map(SaleDetailDTO::getSubTotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .setScale(2, RoundingMode.HALF_UP);


    return SaleDTO.builder()
            .id(sale.getId())
            .date(sale.getDate())
            .status(sale.getStatus())
            .storeId(sale.getStore().getId())
            .detail(detailList)
            .total(total)
            .build();
  }


  //Mapping from Store to StoreDTO
  public static StoreDTO toDTO(Store s){
    if(s == null) return null;

    return StoreDTO.builder()
            .id(s.getId())
            .name(s.getName())
            .address(s.getAddress())
            .build();
  }

}
