package com.xpc.easyes.sample.test;

import com.xpc.easyes.autoconfig.annotation.EsMapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * <p>
 * Copyright © 2021 xpc1024 All Rights Reserved
 **/
@SpringBootApplication
@EsMapperScan("com.xpc.easyes.sample.mapper")
public class TestEasyEsApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestEasyEsApplication.class, args);
    }
}
