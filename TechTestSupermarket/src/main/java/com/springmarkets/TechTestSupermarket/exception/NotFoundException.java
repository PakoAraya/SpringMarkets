package com.springmarkets.TechTestSupermarket.exception;

public class NotFoundException extends RuntimeException{
  public NotFoundException(String msg){
    super(msg);
  }
}
