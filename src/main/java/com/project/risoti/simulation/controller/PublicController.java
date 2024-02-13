package com.project.risoti.simulation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping
    public ResponseEntity<?> get() {
        return ResponseEntity.ok("Should be accessible");
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<?> get(@PathVariable("name") String name) {
        return ResponseEntity.ok("Hello " + name);
    }
}
