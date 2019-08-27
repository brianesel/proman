package com.proman.security.services;

import com.proman.security.repo.UserRepo;
import com.proman.security.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserServicesImpl implements UserServices {
    @Autowired
    UserRepo userRepo;

    public Long getUserId() {
        Long userId = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userId = ((UserPrincipal) principal).getId();
        return userId;
    }

}
