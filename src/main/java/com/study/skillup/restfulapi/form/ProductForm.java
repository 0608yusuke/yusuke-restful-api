package com.study.skillup.restfulapi.form;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Data
public class ProductForm {

  @Autowired private MessageSource messageSource;

  @NotBlank(message = "{error.products.required}")
  private String title;

  @NotBlank(message = "{error.products.required}")
  private String description;

  @Range(min = 1, max = 1000000)
  private Integer price;
}
