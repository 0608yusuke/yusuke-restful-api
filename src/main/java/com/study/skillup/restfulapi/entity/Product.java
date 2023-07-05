package com.study.skillup.restfulapi.entity;

import com.study.skillup.restfulapi.form.ProductForm;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
@Table(name = "restful_api")
public class Product {

  public static Product of(ProductForm productForm) {
    Product insertion_product_form = new Product();

    insertion_product_form.setTitle(productForm.getTitle());
    insertion_product_form.setDescription(productForm.getDescription());
    insertion_product_form.setPrice(productForm.getPrice().intValue());
    return insertion_product_form;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String description;

  private int price;

  private String image_path;

  @CreationTimestamp private LocalDateTime create_time;

  @UpdateTimestamp private LocalDateTime updateTime;
}
