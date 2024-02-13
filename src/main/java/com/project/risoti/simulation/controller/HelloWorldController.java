package com.project.risoti.simulation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping
    public ResponseEntity<?> sayHello(Principal principal) {
        return ResponseEntity.ok("Hello " + principal.getName());
    }
}
