package com.example.demow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.demow.mapper")
public class DemowApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemowApplication.class, args);
	}

}
