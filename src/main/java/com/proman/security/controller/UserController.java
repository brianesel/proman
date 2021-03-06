package com.proman.security.controller;

import com.proman.backendApp.model.CVStorage;
import com.proman.backendApp.repo.CVStorageRepo;
import com.proman.security.repo.UserRepo;

import com.proman.security.security.UserPrincipal;
import com.proman.security.services.UserServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CVStorageRepo cvStorageRepo;

    @Autowired
    private UserServicesImpl userServices;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public Object currentUser() {
        return userRepo.findById(userServices.getUserId());
    }

    @RequestMapping(value = "/download/profilepicture", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public ResponseEntity<Resource> userProfilePicture() {

        CVStorage userCVFile = cvStorageRepo.getOne(userServices.getUserId());
        return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType("image/jpeg"))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "photo" + "\"")
        .body(new ByteArrayResource(userCVFile.getProfilePicture()));
        
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public Object fileUploader() {

        Long userId;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userId = ((UserPrincipal) principal).getId();
        return userRepo.findById(userId);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseBody
    public ResponseEntity<Resource> fileDownloader() {

        CVStorage userCVFile = cvStorageRepo.getOne(userServices.getUserId());
        return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType("application/pdf"))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "hello" + "\"")
        .body(new ByteArrayResource(userCVFile.getProfilePicture()));
        
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String forAdmin() {

        return "welcome admin";
    }

}
