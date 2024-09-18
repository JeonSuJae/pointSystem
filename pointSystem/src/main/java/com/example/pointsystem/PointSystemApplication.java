package com.example.pointsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackageClasses = PointSystemApplication.class)
@SpringBootApplication
public class PointSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointSystemApplication.class, args);
	}

}
