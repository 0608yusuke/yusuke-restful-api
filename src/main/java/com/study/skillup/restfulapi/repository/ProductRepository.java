package com.study.skillup.restfulapi.repository;

import com.study.skillup.restfulapi.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findByTitleContainingOrderByUpdateTimeDesc(String title);

  Product findById(long id);
}
