package com.proman.saleforce.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

import com.payloads.response.saleforce.tokenResponse;
import com.proman.saleforce.model.Product;

public interface ProductService {
    // ResponseEntity<Object> createProduct(ProductRequest orderRequest);
    // ResponseEntity<Object> updateProduct(ProductRequest orderRequest);
    List<Product> getAllProducts();
    tokenResponse getToken();
}
