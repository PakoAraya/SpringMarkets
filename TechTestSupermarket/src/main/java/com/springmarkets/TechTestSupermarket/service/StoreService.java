package com.springmarkets.TechTestSupermarket.service;

import com.springmarkets.TechTestSupermarket.dto.StoreDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService implements IStoreService {

  @Override
  public List<StoreDTO> getStores() {
    return List.of();
  }

  @Override
  public StoreDTO setStore(StoreDTO storeDTO) {
    return null;
  }

  @Override
  public StoreDTO updateStore(Long id, StoreDTO storeDTO) {
    return null;
  }

  @Override
  public void deleteStore(Long id) {

  }
}
