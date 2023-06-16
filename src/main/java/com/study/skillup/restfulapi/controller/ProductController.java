package com.study.skillup.restfulapi.controller;

import com.study.skillup.restfulapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/api/products")
  public String aaa() {
    return "aa";
    // public List<Product> getSelectedByTitle(@RequestParam String title) {
    // return productService.findByTitle(title);
  }
}
