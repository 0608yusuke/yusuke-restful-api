package com.study.skillup.restfulapi.controller;

import com.study.skillup.restfulapi.entity.Product;
import com.study.skillup.restfulapi.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/api/products")
  public List<Product> getSelectedByTitle(@RequestParam String title) {
    return productService.findByTitle(title);
  }
}
