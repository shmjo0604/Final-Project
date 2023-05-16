package com.example.finalproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.mapper"})
@ComponentScan(basePackages = {
	"com.example.controller",
	"com.example.service",
	"com.example.service.classproduct",
	"com.example.service.classunit",
	"com.example.service.member",
	"com.example.service",
	"com.example.restcontroller",
	"com.example.config"
})
public class FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

}
