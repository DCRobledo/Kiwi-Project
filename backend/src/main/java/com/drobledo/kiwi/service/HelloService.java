package com.drobledo.kiwi.service;

import com.drobledo.kiwi.entity.HelloDB;
import com.drobledo.kiwi.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HelloService {
    @Autowired
    private HelloRepository helloRepository;

    @Transactional
    public String getMessageById(int id) {
        return helloRepository.findById(id)
                .map(HelloDB::getMessage)
                .orElseThrow(() -> new RuntimeException("Message not found"));
    }
}
