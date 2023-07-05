package com.study.skillup.restfulapi.service;

import com.study.skillup.restfulapi.entity.Product;
import com.study.skillup.restfulapi.form.ProductForm;
import com.study.skillup.restfulapi.repository.ProductRepository;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public ResponseEntity<Product> registerProduct(
      ProductForm productForm, UriComponentsBuilder uriBuilder) {
    Product register_product = Product.of(productForm);
    productRepository.save(register_product);

    URI location =
        uriBuilder.path("api/products/{id}").buildAndExpand(register_product.getId()).toUri();
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(location);
    return new ResponseEntity<>(register_product, headers, HttpStatus.CREATED);
  }

  public ResponseEntity<List<Product>> searchProductsByTitle(String title) {
    List<Product> search_product =
        productRepository.findByTitleContainingOrderByUpdateTimeDesc(title);
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(search_product, headers, HttpStatus.OK);
  }

  public ResponseEntity<Product> searchProductById(long id, UriComponentsBuilder uriBuilder) {
    Product search_product = productRepository.findById(id);
    URI location =
        uriBuilder.path("api/products/{id}").buildAndExpand(search_product.getId()).toUri();
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(location);
    return new ResponseEntity<>(search_product, headers, HttpStatus.OK);
  }

  public ResponseEntity<Product> updateProduct(long id, ProductForm productForm) {
    Product update_product = productRepository.findById(id);

    update_product.setTitle(productForm.getTitle());
    update_product.setDescription(productForm.getDescription());
    update_product.setPrice(productForm.getPrice());
    update_product.setUpdateTime(LocalDateTime.now());
    productRepository.save(update_product);

    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(update_product, headers, HttpStatus.OK);
  }

  public void deleteProduct(long id) throws IOException {

    Product elimination_product = productRepository.findById(id);
    String image_path_to_string = elimination_product.getImage_path();
    if (image_path_to_string != null) {
      Path file_path =
          Paths.get(
              "/Users/yuusuke/study/skillup/yusuke-restful-api/src/main/resources/static/images/",
              "商品" + id,
              image_path_to_string);
      if (Files.exists(file_path)) {
        Files.delete(file_path);

        Path folder_path =
            Paths.get(
                "/Users/yuusuke/study/skillup/yusuke-restful-api/src/main/resources/static/images/",
                "商品" + id);
        Files.deleteIfExists(folder_path);
      }
    }
    productRepository.delete(elimination_product);
  }

  public void createProductIdFolder(long id) throws IOException {
    Path folder_path =
        Paths.get(
            "/Users/yuusuke/study/skillup/yusuke-restful-api/src/main/resources/static/images/",
            "商品" + id);
    if (Files.notExists(folder_path)) {
      Files.createDirectory(folder_path);
    }
  }

  public Product storeImgFile(long id, MultipartFile file) throws IOException {
    Product obtaining_product_img_path = productRepository.findById(id);
    String image_fIle_path_to_string = obtaining_product_img_path.getImage_path();
    if (image_fIle_path_to_string != null) {
      Path file_path =
          Paths.get(
              "/Users/yuusuke/study/skillup/yusuke-restful-api/src/main/resources/static/images/",
              "商品" + id,
              image_fIle_path_to_string);
      if (Files.exists(file_path)) {
        Files.delete(file_path);
      }
    }

    UUID uuid = UUID.randomUUID();
    String uuid_to_string = uuid.toString();
    String file_name = file.getOriginalFilename();
    String extension = file_name.substring(file_name.lastIndexOf("."));

    Path img_file_path =
        Path.of(
            "/Users/yuusuke/study/skillup/yusuke-restful-api/src/main/resources/static/images/",
            "商品" + id,
            uuid_to_string + extension);
    Files.copy(file.getInputStream(), img_file_path);
    Product img_path_product = productRepository.findById(id);
    img_path_product.setImage_path(uuid_to_string + extension);
    return productRepository.save(img_path_product);
  }

  public HttpEntity<byte[]> searchImageFile(long id, String filepath) throws IOException {
    String img_path_to_string =
        "/Users/yuusuke/study/skillup/yusuke-restful-api/src/main/resources/static/images/"
            + "商品"
            + id
            + "/"
            + filepath;
    File image_file = new File(img_path_to_string);
    Path img_path = Paths.get(img_path_to_string);
    Files.probeContentType(img_path);
    HttpHeaders headers = new HttpHeaders();

    byte[] image_file_to_byte = Files.readAllBytes(image_file.toPath());
    headers.setContentType(MediaType.valueOf(Files.probeContentType(img_path)));
    headers.setContentLength(image_file_to_byte.length);

    return new HttpEntity<byte[]>(image_file_to_byte, headers);
  }
}
