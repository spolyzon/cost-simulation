package com.project.risoti.simulation.controller;

import com.project.risoti.simulation.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private final JdbcUserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(JdbcUserDetailsManager userDetailsManager,
                                  PasswordEncoder passwordEncoder) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
//    @Secured("ADMIN")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> registerUser(@RequestBody UserModel user) {
        UserDetails userDetails = User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities("USER")
                .passwordEncoder(passwordEncoder::encode)
                .build();
        userDetailsManager.createUser(userDetails);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
