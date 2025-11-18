package com.springmarkets.TechTestSupermarket.controller;


import com.springmarkets.TechTestSupermarket.dto.StoreDTO;
import com.springmarkets.TechTestSupermarket.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

  @Autowired
  private IStoreService storeService;

  @GetMapping
  public ResponseEntity<List<StoreDTO>> getStores(){
    return ResponseEntity.ok(storeService.getStores());
  }

  @PostMapping
  public ResponseEntity<StoreDTO> create(@RequestBody StoreDTO storeDTO){
    StoreDTO create = storeService.setStore(storeDTO);
    return ResponseEntity.created(URI.create("/api/stores " + create.getId())).body(create);
  }

  @PutMapping("/{id}")
  public ResponseEntity<StoreDTO> update(@PathVariable Long id, @RequestBody StoreDTO storeDTO){
    return ResponseEntity.ok(storeService.updateStore(id, storeDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    storeService.deleteStore(id);
    return ResponseEntity.noContent().build();
  }
}
