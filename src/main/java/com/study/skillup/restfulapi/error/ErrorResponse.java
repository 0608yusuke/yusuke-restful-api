package com.study.skillup.restfulapi.error;

import lombok.Data;

@Data
public class ErrorResponse {

  private int status;

  private String errorMassage;
}
