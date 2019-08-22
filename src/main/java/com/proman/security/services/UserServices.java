// package com.proman.security.services;

// import java.io.IOException;
// import java.net.URI;
// import java.util.Collections;
// import java.util.HashSet;
// import java.util.Set;

// import javax.validation.Valid;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestHeader;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestPart;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import io.micrometer.core.lang.Nullable;

// import org.springframework.util.StringUtils;

// import com.proman.backendApp.model.CVStorage;
// import com.proman.backendApp.model.Company;
// import com.proman.backendApp.model.SkillLevel;
// import com.proman.backendApp.model.SkillLevelKey;
// import com.proman.backendApp.model.Skills;
// import com.proman.backendApp.repo.CompanyRepo;
// import com.proman.backendApp.repo.SkillLevelRepo;
// import com.proman.backendApp.repo.SkillsRepo;
// import com.proman.security.exception.AppException;
// import com.proman.security.model.Role;
// import com.proman.security.model.RoleName;
// import com.proman.security.model.User;
// import com.proman.security.repo.RoleRepo;
// import com.proman.security.repo.UserRepo;
// import com.proman.security.security.JwtAuthenticationFilter;
// import com.proman.security.security.JwtTokenProvider;

// import com.payloads.ApiResponse;
// import com.payloads.JwtAuthenticationResponse;
// import com.payloads.LoginRequest;
// import com.payloads.SignUpRequest;

// public interface UserServices {

//     @Autowired
// 	AuthenticationManager authenticationManager;

// 	@Autowired
// 	UserRepo userRepository;

// 	@Autowired
// 	RoleRepo roleRepository;

// 	@Autowired
// 	CompanyRepo companyRepository;

// 	@Autowired
// 	SkillsRepo skillsRepository;

// 	@Autowired
// 	SkillLevelRepo skillLevelRepository;

// 	@Autowired
// 	PasswordEncoder passwordEncoder;

// 	@Autowired
// 	JwtTokenProvider tokenProvider;

// 	@Autowired
//     JwtAuthenticationFilter jwtAuthenFilter;
    
//     public static ResponseEntity<?> registerUser() {}
        
// }
