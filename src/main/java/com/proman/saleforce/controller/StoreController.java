package com.proman.saleforce.controller;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.micrometer.core.lang.Nullable;

import org.springframework.util.StringUtils;

import com.proman.backendApp.model.CVStorage;
import com.proman.backendApp.model.Company;
import com.proman.backendApp.model.SkillLevel;
import com.proman.backendApp.model.SkillLevelKey;
import com.proman.backendApp.model.Skills;
import com.proman.backendApp.repo.CompanyRepo;
import com.proman.backendApp.repo.SkillLevelRepo;
import com.proman.backendApp.repo.SkillsRepo;
import com.proman.security.exception.AppException;
import com.proman.security.model.Role;
import com.proman.security.model.RoleName;
import com.proman.security.model.User;
import com.proman.security.repo.RoleRepo;
import com.proman.security.repo.UserRepo;
import com.proman.security.security.JwtAuthenticationFilter;
import com.proman.security.security.JwtTokenProvider;
import com.proman.saleforce.service.OrderService;
import com.proman.saleforce.service.ProductService;
import com.payloads.ApiResponse;
import com.payloads.JwtAuthenticationResponse;
import com.payloads.LoginRequest;
import com.payloads.SignUpRequest;
import com.payloads.request.saleforce.OrderRequest;
import com.payloads.response.saleforce.tokenResponse;

@RestController
@RequestMapping("/api/saleforce")
@CrossOrigin(origins = "*")
// @PreAuthorize("hasRole('USER')")
public class StoreController {

	@Autowired
	OrderService orderService;

	@Autowired
	ProductService productService;

	@PostMapping("/shoes/createOrder")
	public ResponseEntity<?> createOrder(@Valid @RequestParam("Account__c") String account,@Valid @RequestParam("Product__c") String product,@Valid @RequestParam("Billing_address__c") String bill,@Valid @RequestParam("Shipping_address__c") String ship,@Valid @RequestParam("status__c") int status,@Valid @RequestParam("Quantity__c") int quantity) {
		System.out.println(account);
		OrderRequest orderRequest = new OrderRequest();
		orderRequest.setUp(account, bill, ship, product, quantity, status);
		return ResponseEntity.ok(orderService.createOrder(orderRequest));
	}
	@PostMapping("/shoes/updateOrder")
	public ResponseEntity<?> updateOrder(@Valid @RequestParam("Account__c") String account,@Valid @RequestParam("Product__c") String product,@Valid @RequestParam("Billing_address__c") String bill,@Valid @RequestParam("Shipping_address__c") String ship,@Valid @RequestParam("status__c") int status,@Valid @RequestParam("Quantity__c") int quantity) {
		
		return null;
	}

	@GetMapping("/shoes/getAll")
	public ResponseEntity<?> getShoes() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@GetMapping("/token")
	public tokenResponse getToken() {
		return productService.getToken();
	}
}
