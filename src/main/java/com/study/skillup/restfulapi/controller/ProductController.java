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
  public ResponseEntity<Product> registerProduct(
      @Valid @RequestBody ProductForm productForm, UriComponentsBuilder uriBuilder) {
    return productService.registerProduct(productForm, uriBuilder);
  }

  @GetMapping()
  public ResponseEntity<List<Product>> searchProductByTitle(@RequestParam String title) {
    return productService.searchProductsByTitle(title);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> searchProductById(
      @PathVariable(value = "id") Long id, UriComponentsBuilder uriBuilder) {
    return productService.searchProductById(id, uriBuilder);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(
      @PathVariable(value = "id") Long id, @RequestBody ProductForm productForm) {
    return productService.updateProduct(id, productForm);
  }

  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable(value = "id") Long id) throws IOException {
    productService.deleteProduct(id);
  }

  @PatchMapping(value = "/{id}/images")
  public Product updateProductImg(
      @PathVariable(value = "id") Long id, @RequestPart("productImage") MultipartFile file)
      throws IOException {
    productService.createProductIdFolder(id);
    return productService.storeImgFile(id, file);
  }

  @GetMapping("/{id}/images/{filepath}")
  public HttpEntity<byte[]> searchProductImage(@PathVariable Long id, @PathVariable String filepath)
      throws IOException {
    return productService.searchImageFile(id, filepath);
  }

  @GetMapping("/test")
  public void test() {
    productService.test();
  }
}
