package com.springmarkets.TechTestSupermarket.service;

import com.springmarkets.TechTestSupermarket.dto.SaleDTO;
import com.springmarkets.TechTestSupermarket.dto.SaleDetailDTO;
import com.springmarkets.TechTestSupermarket.exception.NotFoundException;
import com.springmarkets.TechTestSupermarket.mapper.Mapper;
import com.springmarkets.TechTestSupermarket.model.Product;
import com.springmarkets.TechTestSupermarket.model.Sale;
import com.springmarkets.TechTestSupermarket.model.SaleDetail;
import com.springmarkets.TechTestSupermarket.model.Store;
import com.springmarkets.TechTestSupermarket.repository.ProductRepository;
import com.springmarkets.TechTestSupermarket.repository.SaleRepository;
import com.springmarkets.TechTestSupermarket.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService implements ISaleService {

  @Autowired
  private SaleRepository saleRepository;
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private StoreRepository storeRepository;

  @Override
  public List<SaleDTO> getSales() {

    List<Sale> sales = saleRepository.findAll();
    List<SaleDTO> salesDTO = new ArrayList<>();

    SaleDTO dto;
    for(Sale s : sales){
      dto = Mapper.toDTO(s);
      salesDTO.add(dto);
    }

    /* Best way to develop this method
    for (Sale s : sale) {
      saleDTO.add(Mapper.toDTO(s));
    } */
    return salesDTO;
  }

  @Override
  public SaleDTO setSale(SaleDTO saleDTO) {
    //First step, check if store, sale, and products exists
    if(saleDTO == null) throw new RuntimeException("SaleDTO is null...");
    if(saleDTO.getStoreId() == null) throw new RuntimeException("The Store must be displayed...");
    if(saleDTO.getDetail() == null || saleDTO.getDetail().isEmpty())
      throw new RuntimeException("It must include at least one product...");

    //Search store
    Store store = storeRepository.findById(saleDTO.getStoreId())
            .orElseThrow(() -> new RuntimeException("Store not found..."));

    /*Another Way
    Store store = storeRepository.findById(saleDTO.getStoreId()).orElse(null);
    if(store == null) {
      throw new NotFoundException("Store not found...");
    } */

    //Create sale
    Sale sale = new Sale();
    sale.setDate(saleDTO.getDate());
    sale.setStatus(saleDTO.getStatus());
    sale.setStore(store);
    sale.setTotal(saleDTO.getTotal());

    //List Sale Detail
    List<SaleDetail> saleDetails = new ArrayList<>();
    BigDecimal calculatedTotal = BigDecimal.ZERO;

    for(SaleDetailDTO sdDTO : saleDTO.getDetail()){
      //Search product by id (your saleDetailDTO use idProduct)
      Product product = productRepository.findByName(sdDTO.getProductName()).orElse(null);
      if(product == null) {
        throw new RuntimeException("Product not found..." + sdDTO.getProductName());
      }

      //Create Sale Detail
      SaleDetail saleDetail = new SaleDetail();
      saleDetail.setProduct(product);
      saleDetail.setProdQuantity(sdDTO.getProductQuantity());
      saleDetail.setUnitPrice(sdDTO.getProductPrice());
      saleDetail.setSale(sale);

      saleDetails.add(saleDetail);
      /* Professional way to calculate total
      calculatedTotal = calculatedTotal.add(sdDTO.getProductPrice().multiply(new BigDecimal(sdDTO.getProductQuantity())));
      */

      // Simplified way to calculate total to understand logic
      // total = total + (price * quantity)
      BigDecimal price = sdDTO.getProductPrice();
      BigDecimal quantity = new BigDecimal(sdDTO.getProductQuantity());
      BigDecimal lineTotal = price.multiply(quantity);
      calculatedTotal = calculatedTotal.add(lineTotal);

      /* If we work with primitive types like Double
      calculatedTotal = calculatedTotal + (sdDTO.getProductPrice() * sdDTO.getProductQuantity());
       */

    }
    //Setting sale details list
    sale.setSaleDetails(saleDetails);

    //Save in DB
    /*
    // Ensure that we fetch the updated entity directly from the database,
    // not the logical input object, so we always return the persisted
    // and normalized values exactly as stored in the DB.
    */
    sale = saleRepository.save(sale);

    //Output Mapping
    SaleDTO saleOutput = Mapper.toDTO(sale);
    return saleOutput;
    //return Mapper.toDTO(saleRepository.save(sale)); Optimized way
  }

  @Override
  public SaleDTO updateSale(Long id, SaleDTO saleDTO) {
    //First Step check if sale exists to update
    Sale sale = saleRepository.findById(id).orElse(null);
    if(sale == null) {
      throw new NotFoundException("Sale not found. Update cannot be completed with id: " + id);
    }

    if(saleDTO.getDate() != null){
      sale.setDate(saleDTO.getDate());
    }

    if(saleDTO.getStatus() != null){
      sale.setStatus(saleDTO.getStatus());
    }

    if(saleDTO.getTotal() != null){
      sale.setTotal(saleDTO.getTotal());
    }

    if(saleDTO.getStoreId() != null){
      Store store = storeRepository.findById(saleDTO.getStoreId()).orElse(null);
      if(store == null) {
        throw new NotFoundException("Store not found. Update cannot be completed with id: " + saleDTO.getStoreId());
      }
      sale.setStore(store);
    }
    saleRepository.save(sale);


    SaleDTO saleOutput = Mapper.toDTO(sale);
    return saleOutput;
  }

  @Override
  public void deleteSale(Long id) {
    if(!saleRepository.existsById(id))
      throw new NotFoundException("Sale not found. Deletion cannot be completed with id: " + id);
    saleRepository.deleteById(id);

    /* Another Way
    Sale sale = saleRepository.findById(id).orElse(null);
    if(sale == null) {
      throw new NotFoundException("Sale not found. Deletion cannot be completed with id: " + id);
    }
    saleRepository.deleteById(id);
  */
  }

}
