package com.study.skillup.restfulapi.controller;

import com.study.skillup.restfulapi.entity.Product;
import com.study.skillup.restfulapi.form.ProductForm;
import com.study.skillup.restfulapi.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping()
  public List<Product> getSelectedByTitle(@RequestParam String title) {
    return productService.findByTitle(title);
  }

  @PostMapping()
  public Product register(@RequestBody ProductForm productForm) {
    return productService.register(productForm);
  }
}
