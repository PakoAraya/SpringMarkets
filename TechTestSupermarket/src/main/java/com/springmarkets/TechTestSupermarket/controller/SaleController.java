package com.springmarkets.TechTestSupermarket.controller;


import com.springmarkets.TechTestSupermarket.dto.SaleDTO;
import com.springmarkets.TechTestSupermarket.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

  @Autowired
  private ISaleService saleService;

  @GetMapping
  public ResponseEntity<List<SaleDTO>> getSales(){
    return ResponseEntity.ok(saleService.getSales());
  }

  /**
   * Create a sale using directly SaleDTO in request (Simple Option, without separated request)
   * Wait for the DTO brings information
   */
  @PostMapping
  public ResponseEntity<SaleDTO> createSale(@RequestBody SaleDTO saleDTO){
    SaleDTO created = saleService.setSale(saleDTO);
    return ResponseEntity.created(URI.create("/api/sales " + created.getId())).body(created);
  }

  @PutMapping("/{id}")
  public SaleDTO updateSale(@PathVariable Long id, @RequestBody SaleDTO saleDTO){
   //Update date, status, idStore, total and replace detail
    return saleService.updateSale(id, saleDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSale(@PathVariable Long id){
    saleService.deleteSale(id);
    return ResponseEntity.noContent().build();
  }

}
