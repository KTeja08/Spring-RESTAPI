package com.springrest.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springrest.springrest.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
