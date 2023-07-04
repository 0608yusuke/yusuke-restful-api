package com.study.skillup.restfulapi.error;

public class NotFoundException extends RuntimeException{

  

  public NotFoundException(String message) {
    super(message);
  }
}
