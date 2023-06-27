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

  public static Product register(ProductForm productForm) {
    Product product = new Product();

    product.setTitle(productForm.getTitle());
    product.setDescription(productForm.getDescription());
    product.setPrice(productForm.getPrice().intValue());
    return product;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String description;

  private int price;

  private byte[] image_path;

  @CreationTimestamp private LocalDateTime create_time;

  @UpdateTimestamp private LocalDateTime updateTime;
}
