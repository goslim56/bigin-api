package com.bigin.biginapi.repository;

import com.bigin.biginapi.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Integer>{
}
