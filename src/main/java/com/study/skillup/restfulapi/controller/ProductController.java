package com.study.skillup.restfulapi.controller;

import com.study.skillup.restfulapi.entity.Product;
import com.study.skillup.restfulapi.form.ProductForm;
import com.study.skillup.restfulapi.service.ProductService;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
// @MultipartConfig(location = )
public class ProductController {

  private final ProductService productService;

  public Product register(@RequestBody ProductForm productForm) {
    return productService.register(productForm);
  }

  @GetMapping()
  public List<Product> searchPluralByTitle(@RequestParam String title) {
    return productService.findByTitle(title);
  }

  @GetMapping("/{id}")
  public Product searchById(@PathVariable(value = "id") Long id) {
    return productService.findById(id);
  }

  @PutMapping("/{id}")
  public Product update(@PathVariable(value = "id") Long id, @RequestBody ProductForm productForm) {
    return productService.update(id, productForm);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable(value = "id") Long id) {
    productService.delete(id);
  }

  @PatchMapping("/{id}/images")
  public void registerImg(
      @PathVariable(value = "id") Long id, @RequestPart("productImage") MultipartFile file)
      throws IOException {
    productService.saveImg(id, file);
  }
}
