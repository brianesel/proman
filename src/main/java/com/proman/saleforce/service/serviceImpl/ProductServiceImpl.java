package com.proman.saleforce.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import com.payloads.response.saleforce.tokenResponse;
import com.proman.saleforce.model.Product;
import com.proman.saleforce.service.ProductService;
import com.proman.saleforce.service.SaleforceService;

@Service
public class ProductServiceImpl implements ProductService {

    // @Value("${app.passwordEnc}")
    // private String passwordEnc;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    private final SaleforceService sfs;

    @Autowired
    public ProductServiceImpl(SaleforceService sfs) {
        this.sfs = sfs;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<Product>();
        return sfs.authen("get");
    }
    @Override
    public tokenResponse getToken(){
        return sfs.token();
    }
}
