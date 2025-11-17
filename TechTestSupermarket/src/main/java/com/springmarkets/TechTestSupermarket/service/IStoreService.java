package com.springmarkets.TechTestSupermarket.service;

import com.springmarkets.TechTestSupermarket.dto.StoreDTO;
import com.springmarkets.TechTestSupermarket.model.Store;

import java.util.List;

public interface IStoreService {
  List<StoreDTO> getStores();
  StoreDTO setStore(StoreDTO storeDTO);
  StoreDTO updateStore(Long id, StoreDTO storeDTO);
  void deleteStore(Long id);
}
