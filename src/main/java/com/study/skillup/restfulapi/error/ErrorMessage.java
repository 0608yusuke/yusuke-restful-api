package com.study.skillup.restfulapi.error;

import lombok.Data;

@Data
public class ErrorMessage {

  private int status;

  private String errorMassage;
}
