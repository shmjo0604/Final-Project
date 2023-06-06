package com.example.finalproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@PropertySource(value = {"classpath:global.properties"})
@EntityScan(basePackages = {"com.example.entity"})
@EnableJpaRepositories(basePackages = {"com.example.repository"})
@MapperScan(basePackages = {"com.example.mapper"})
@ComponentScan(basePackages = {
	"com.example.controller",
	"com.example.service",
	"com.example.service.classproduct",
	"com.example.service.member",
	"com.example.service.apply",
	"com.example.service.review",
	"com.example.service.community",
	"com.example.service.basket",
	"com.example.service.notification",
	"com.example.restcontroller",
	"com.example.config",
	"com.example.filter"
})
public class FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}

}