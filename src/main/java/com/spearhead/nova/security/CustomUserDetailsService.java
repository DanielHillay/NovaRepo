package com.spearhead.nova.security;

import javax.transaction.Transactional;

import com.spearhead.nova.model.AdminUser;
import com.spearhead.nova.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spearhead.nova.model.User;
import com.spearhead.nova.model.UserPrincipal;
import com.spearhead.nova.repository.UserRepository;




@Service
public class CustomUserDetailsService implements UserDetailsService {


    
    @Autowired
    AdminRepository adminRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        AdminUser user = adminRepository.findByEmail(email)
                .orElseThrow(() -> 
                new BadCredentialsException("Either email or password is incorrect")
        );

        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long adminId) {
        AdminUser user = adminRepository.findByUserId(adminId).orElseThrow(
            () -> new UsernameNotFoundException("User not found with id : " + adminId)
        );

        return UserPrincipal.create(user);
    }
}