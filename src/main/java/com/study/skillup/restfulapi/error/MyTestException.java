package com.study.skillup.restfulapi.error;

public class MyTestException extends Exception {

  private static final long serialVersionUID = 1L;

  public MyTestException(String msg){
      super(msg);
  }
}
