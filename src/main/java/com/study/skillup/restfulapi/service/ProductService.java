package com.study.skillup.restfulapi.service;

import com.study.skillup.restfulapi.entity.Product;
import com.study.skillup.restfulapi.form.ProductForm;
import com.study.skillup.restfulapi.repository.ProductRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
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

  public void createIdFolder(long id) {
    try {
      Path path =
          Paths.get(
              "/Users/yuusuke/study/skillup/yusuke-restful-api/src/main/resources/static/images/",
              "商品" + id);
      Files.createDirectory(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void storageFile(long id, MultipartFile file) {
    UUID uuid = UUID.randomUUID();
    String str = uuid.toString();
    Path path =
        Path.of(
            "/Users/yuusuke/study/skillup/yusuke-restful-api/src/main/resources/static/images/",
            "商品" + id,
            str);
    try {
      Files.copy(file.getInputStream(), path);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
