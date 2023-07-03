package com.study.skillup.restfulapi.controller;

import com.study.skillup.restfulapi.entity.Product;
import com.study.skillup.restfulapi.form.ProductForm;
import com.study.skillup.restfulapi.service.ProductService;
import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @PostMapping()
  public ResponseEntity<Product> register(
      @Valid @RequestBody ProductForm productForm, UriComponentsBuilder uriBuilder) {
    return productService.register(productForm, uriBuilder);
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
  public void delete(@PathVariable(value = "id") Long id) throws IOException {
    productService.delete(id);
  }

  @PatchMapping(value = "/{id}/images")
  public Product registerImg(
      @PathVariable(value = "id") Long id, @RequestPart("productImage") MultipartFile file) {
    productService.createIdFolder(id);
    productService.storageImgFile(id, file);
    return productService.findById(id);
  }

  @GetMapping("/{id}/images/{filepath}")
  public HttpEntity<byte[]> getProductImage(@PathVariable Long id, @PathVariable String filepath)
      throws IOException {
    return productService.searchImageFile(id, filepath);
  }
}
