package com.study.skillup.restfulapi.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class ProductForm {

  private String title;

  
  private String description;

  @Range(min=1, max=1000000 )
  private Integer price;
}
