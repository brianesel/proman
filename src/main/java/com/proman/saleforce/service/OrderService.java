package com.proman.saleforce.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

import com.payloads.request.saleforce.OrderRequest;

public interface OrderService {
    ResponseEntity<?> createOrder(OrderRequest orderRequest);
    ResponseEntity<Object> updateOrder(OrderRequest orderRequest);
    ResponseEntity<Object> getAllOrder(OrderRequest orderRequest);
}
