package com.springmarkets.TechTestSupermarket.service;

import com.springmarkets.TechTestSupermarket.dto.StoreDTO;
import com.springmarkets.TechTestSupermarket.exception.NotFoundException;
import com.springmarkets.TechTestSupermarket.mapper.Mapper;
import com.springmarkets.TechTestSupermarket.model.Store;
import com.springmarkets.TechTestSupermarket.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService implements IStoreService {

  @Autowired
  private StoreRepository storeRepository;

  @Override
  public List<StoreDTO> getStores() {
    return storeRepository.findAll()
            .stream()
            .map(Mapper::toDTO)
            .toList();
  }

  @Override
  public StoreDTO setStore(StoreDTO storeDTO) {
    Store store = Store.builder()
            .name(storeDTO.getName())
            .address(storeDTO.getAddress())
            .build();
    return Mapper.toDTO(storeRepository.save(store));
  }

  @Override
  public StoreDTO updateStore(Long id, StoreDTO storeDTO) {
    Store store = storeRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Store not found..."));

    store.setName(storeDTO.getName());
    store.setAddress(storeDTO.getAddress());

    return Mapper.toDTO(storeRepository.save(store));
  }

  @Override
  public void deleteStore(Long id) {
    if(!storeRepository.existsById(id))
      throw new NotFoundException("Store not found. Deletion cannot be completed with id: " + id);

    storeRepository.deleteById(id);
  }
}
