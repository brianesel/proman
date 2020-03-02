package com.proman.saleforce.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import com.payloads.request.saleforce.OrderRequest;
import com.proman.saleforce.service.OrderService;
import com.proman.saleforce.service.SaleforceService;

@Service
public class OrderServiceImpl implements OrderService {

    // @Value("${app.passwordEnc}")
    // private String passwordEnc;
    
    @Autowired
	PasswordEncoder passwordEncoder;
    @Autowired
    private final SaleforceService sfs;

    @Autowired
    public OrderServiceImpl(SaleforceService sfs) {
        this.sfs = sfs;
    }

    @Override
    public ResponseEntity<?> createOrder(OrderRequest orderRequest) {
        return sfs.updateOrderRequest(orderRequest);
    }

    // @Override
    // public List<OrderResponse> getAllOrders() {
       
    //     return userResponses;
    // }

    // @Override
    // public ResponseEntity<ResponseObject> resetOrderPassword(ResetPassword resetPassword) {
    // }

    // @Override
    // public ResponseEntity<ResponseObject> updateOrder(Order user) {
        
    // }

    // @Override
    // public ResponseEntity<ResponseObject> deleteOrder(int id) {
        
    // }

    @Override
    public ResponseEntity<Object> updateOrder(OrderRequest orderRequest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<Object> getAllOrder(OrderRequest orderRequest) {
        // TODO Auto-generated method stub
        return null;
    }
}
