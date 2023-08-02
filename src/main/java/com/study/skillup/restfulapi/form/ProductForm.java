package com.study.skillup.restfulapi.form;

import java.util.Locale;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Data
public class ProductForm {

  @Autowired private MessageSource messageSource;
  String msg = messageSource.getMessage("hello", null, Locale.JAPANESE);

  @NotBlank(message = "aaa")
  private String title;

  @NotBlank(message = "{error.products.required}")
  private String description;

  @Range(min = 1, max = 1000000)
  private Integer price;
}
