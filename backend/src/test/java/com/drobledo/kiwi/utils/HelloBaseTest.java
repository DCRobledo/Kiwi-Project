package com.drobledo.kiwi.utils;

import com.drobledo.kiwi.entity.HelloDB;
import com.drobledo.kiwi.repository.HelloRepository;
import com.drobledo.kiwi.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class HelloBaseTest {

    @Mock
    protected HelloRepository helloRepository;

    @InjectMocks
    protected HelloService helloService;
    
    protected HelloDB helloDB;
    
    @BeforeEach
    public void setUp() {
        helloDB = new HelloDB(1, "Hello World!");
    }
}

