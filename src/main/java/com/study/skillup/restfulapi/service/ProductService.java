package com.study.skillup.restfulapi.service;

import com.study.skillup.restfulapi.entity.Product;
import com.study.skillup.restfulapi.form.ProductForm;
import com.study.skillup.restfulapi.repository.ProductRepository;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public Product register(ProductForm productForm) {
    return productRepository.save(Product.register(productForm));
  }

  public List<Product> findByTitle(String title) {
    return productRepository.findByTitleContainingOrderByUpdateTimeDesc(title);
  }

  public Product findById(long id) {
    return productRepository.findById(id);
  }

  public Product update(long id, ProductForm productForm) {
    Product update_product = productRepository.findById(id);

    update_product.setTitle(productForm.getTitle());
    update_product.setDescription(productForm.getDescription());
    update_product.setPrice(productForm.getPrice().intValue());
    update_product.setUpdateTime(LocalDateTime.now());

    return productRepository.save(update_product);
  }

  public void delete(long id) {
    Product deleted_product = productRepository.findById(id);
    productRepository.delete(deleted_product);
  }

  public Product saveImg(long id, MultipartFile file) throws IOException {
    Product storage_img_product = productRepository.findById(id);
    byte[] change_byte = file.getBytes();
    String change_string = new String(change_byte);

    storage_img_product.setImage_path(change_string.getBytes());

    return productRepository.save(storage_img_product);
  }
}
