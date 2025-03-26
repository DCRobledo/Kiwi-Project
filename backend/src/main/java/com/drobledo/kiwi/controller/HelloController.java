package com.drobledo.kiwi.controller;

import com.drobledo.kiwi.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private HelloService helloService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getMessageById(@PathVariable int id) {
        String message = helloService.getMessageById(id);
        return ResponseEntity.ok(Collections.singletonMap("message", message));
    }
}
