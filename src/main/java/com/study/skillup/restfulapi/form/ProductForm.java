package com.study.skillup.restfulapi.form;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class ProductForm {

  @NotBlank private String title;

  @NotBlank private String description;

  @Range(min = 1, max = 1000000)
  private Integer price;
}
