package com.study.skillup.restfulapi.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class ErrorResponse {
  @JsonProperty("Error")
  private Error error;

  public ErrorResponse(String message, String detail, String code) {
    this.error = new Error(message, detail, code);
  }

  @Value
  private class Error {
    @JsonProperty("Message")
    private final String message;

    @JsonProperty("Detail")
    private final String detail;

    @JsonProperty("Code")
    private final String code;
  }
}
