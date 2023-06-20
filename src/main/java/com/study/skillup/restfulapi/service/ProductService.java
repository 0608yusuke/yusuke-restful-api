package com.study.skillup.restfulapi.service;

import com.study.skillup.restfulapi.entity.Product;
import com.study.skillup.restfulapi.form.ProductForm;
import com.study.skillup.restfulapi.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    Product updateProduct = productRepository.findById(id);

    updateProduct.setTitle(productForm.getTitle());
    updateProduct.setDescription(productForm.getDescription());
    updateProduct.setPrice(productForm.getPrice().intValue());
    updateProduct.setUpdateTime(LocalDateTime.now());

    return productRepository.save(updateProduct);
  }

  public void delete(long id) {
    Product deleteProduct = productRepository.findById(id);
    productRepository.delete(deleteProduct);
  }
}
