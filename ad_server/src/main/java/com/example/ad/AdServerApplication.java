package com.example.ad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ad.dao")
public class AdServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdServerApplication.class, args);
    }

}
