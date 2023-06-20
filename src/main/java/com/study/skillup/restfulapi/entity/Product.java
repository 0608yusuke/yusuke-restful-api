package com.study.skillup.restfulapi.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
@Table(name= "restful_api")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String description;

  private int price;

  @CreationTimestamp private LocalDateTime createTime;

  @UpdateTimestamp private LocalDateTime updateTime;
}
