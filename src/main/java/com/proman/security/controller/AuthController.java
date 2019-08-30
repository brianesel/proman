package com.proman.security.controller;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
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

import com.payloads.ApiResponse;
import com.payloads.JwtAuthenticationResponse;
import com.payloads.LoginRequest;
import com.payloads.SignUpRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepo userRepository;

	@Autowired
	RoleRepo roleRepository;

	@Autowired
	CompanyRepo companyRepository;

	@Autowired
	SkillsRepo skillsRepository;

	@Autowired
	SkillLevelRepo skillLevelRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;

	@Autowired
	JwtAuthenticationFilter jwtAuthenFilter;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}

	@GetMapping("/checkUserStatus")
	public boolean userStatus(@RequestHeader("Authorization") String bearerToken) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean isAuthenticated = authentication.isAuthenticated();
		String jwt;
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			jwt = bearerToken.substring(7, bearerToken.length());
		} else {
			jwt = null;
		}
		boolean checkToken = tokenProvider.validateToken(jwt);
		if (isAuthenticated == true && checkToken == true) {
			return true;
		} else {
			return false;
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestPart("signupRequest") SignUpRequest signUpRequest, @Nullable @RequestPart("profileImage") MultipartFile profileImage, @Nullable @RequestPart("cvFile") MultipartFile cvFile, @Nullable @RequestPart("motiLetter") MultipartFile motiLetter) throws IOException {

		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
		}
		CVStorage userCVStorage = new CVStorage();
		if(profileImage != null && (profileImage.getContentType() == "image/jpeg")){
			userCVStorage.setProfilePicture(profileImage.getBytes());
		} else return new ResponseEntity(new ApiResponse(false, "Wrong MIME type. You should upload jpeg files"), HttpStatus.BAD_REQUEST);
		if(cvFile !=null && cvFile.getContentType() == "application/pdf"){
			userCVStorage.setCV(cvFile.getBytes());
		} else return new ResponseEntity(new ApiResponse(false, "Wrong MIME type. You should upload pdf files"), HttpStatus.BAD_REQUEST);
		if(motiLetter !=null && motiLetter.getContentType() == "application/pdf"){
			userCVStorage.setMotiLetter(motiLetter.getBytes());
		} else return new ResponseEntity(new ApiResponse(false, "Wrong MIME type. You should upload pdf files"), HttpStatus.BAD_REQUEST);
		signUpRequest.setCvStorage(userCVStorage);
		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				signUpRequest.getDateOfBirth(), signUpRequest.getLocation(), signUpRequest.getPassword(),
				signUpRequest.getPhoneNumber(), signUpRequest.getDegree(), signUpRequest.getCompany(),
				signUpRequest.getSocialMedia(), signUpRequest.getSkills(), signUpRequest.getCvStorage());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		try {
			Set<Company> userCompanies = new HashSet<>();
			for (Company currentCompany : user.getCompany()) {
				try {
					companyRepository.save(currentCompany);
				} catch (Exception e) {
				}
				Company userCompany = companyRepository.findByName(currentCompany.getName())
						.orElseThrow(() -> new AppException("Company not found"));
				userCompanies.add(userCompany);
			}
			user.setCompany(userCompanies);
		} catch (Exception e) {
		}
		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
				.orElseThrow(() -> new AppException("User Role not set."));
		user.setRoles(Collections.singleton(userRole));
		User result = userRepository.save(user);
		try {
			
			try {
				for (SkillLevel currentSkill : user.getSkillLevel()) {
					try {
						skillsRepository.save(currentSkill.getSkill());
					} catch (Exception exception) {
						System.out.print(exception);
					}
					Skills userSkill = skillsRepository.findBySkillName(currentSkill.getSkill().getSkillName())
							.orElseThrow(() -> new AppException("Skill not found"));
					currentSkill.setSkill(userSkill);
					User userInfo = userRepository.findByUsername(user.getUsername())
							.orElseThrow(() -> new AppException("User not found"));
					currentSkill.setUser(userInfo);
					if (currentSkill.getId() == null) {
						SkillLevelKey currentSkillId = new SkillLevelKey();
						currentSkillId.setId(userInfo.getId(), userSkill.getId());
						currentSkill.setId(currentSkillId);
					} else
						currentSkill.getId().setId(userInfo.getId(), userSkill.getId());
					try {
						skillLevelRepository.save(currentSkill);
					} catch (Exception e) {
						System.out.print(e);
					}
				}
			} catch(Exception e){}
			URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}")
					.buildAndExpand(result.getUsername()).toUri();
			return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
		} catch (Exception e) {
			userRepository.delete(user);
			return new ResponseEntity(new ApiResponse(false, "User unsuccesfull signup"), HttpStatus.BAD_REQUEST);
		}
	}
}
