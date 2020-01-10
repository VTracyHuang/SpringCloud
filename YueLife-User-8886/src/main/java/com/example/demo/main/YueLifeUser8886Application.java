package com.example.demo.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication()
@ComponentScan({"com.example.demo.handler","com.example.demo.service"})
@MapperScan("com.example.demo.mapper")
@EnableEurekaClient
@EnableRedisHttpSession
public class YueLifeUser8886Application {
	public static void main(String[] args) {
		SpringApplication.run(YueLifeUser8886Application.class, args);
	}
}
