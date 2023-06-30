package com.study.skillup.restfulapi.service;

import com.study.skillup.restfulapi.entity.Product;
import com.study.skillup.restfulapi.form.ProductForm;
import com.study.skillup.restfulapi.repository.ProductRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
    update_product.setPrice(productForm.getPrice());
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

  public void storageImgFile(long id, MultipartFile file) {

    UUID uuid = UUID.randomUUID();
    String str = uuid.toString();

    String fileName = file.getOriginalFilename();
    String extension = fileName.substring(fileName.lastIndexOf("."));

    Path path =
        Path.of(
            "/Users/yuusuke/study/skillup/yusuke-restful-api/src/main/resources/static/images/",
            "商品" + id,
            str + extension);
    try {
      Files.copy(file.getInputStream(), path);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    Product img_path_product = productRepository.findById(id);
    img_path_product.setImage_path(str + extension);
    productRepository.save(img_path_product);
  }

  public HttpEntity<byte[]> searchImageFile(long id, String filepath) throws IOException {
    String path =
        "/Users/yuusuke/study/skillup/yusuke-restful-api/src/main/resources/static/images/"
            + "商品"
            + id
            + "/"
            + filepath;
    File imageData = new File(path);
    Path path3 = Paths.get(path);
    Files.probeContentType(path3);
    HttpHeaders headers = new HttpHeaders();

    byte[] byteImage = Files.readAllBytes(imageData.toPath());
    headers.setContentType(MediaType.valueOf(Files.probeContentType(path3)));
    headers.setContentLength(byteImage.length);

    return new HttpEntity<byte[]>(byteImage, headers);
  }
}
