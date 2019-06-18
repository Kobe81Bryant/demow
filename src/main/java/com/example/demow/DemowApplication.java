package com.example.demow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@MapperScan(basePackages = "com.example.demow.mapper")
@EnableWebMvc
@EnableWebSocket
public class DemowApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemowApplication.class, args);
    }

}
