package com.bigin.biginapi.service;

import com.bigin.biginapi.domain.product.Product;
import com.bigin.biginapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductDetailAnalysis implements Analysis{
    private final ProductRepository productRepository;

    @Override
    public Optional<Product> analysis() {
        //상품 유사도 분석을 했다는 가정 하에
        return productRepository.findById(3);
    }
}
