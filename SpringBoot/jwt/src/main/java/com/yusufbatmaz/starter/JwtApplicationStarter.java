package com.yusufbatmaz.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.yusufbatmaz" })
@EntityScan(basePackages = { "com.yusufbatmaz" })
@EnableJpaRepositories(basePackages = { "com.yusufbatmaz" })
@SpringBootApplication
public class JwtApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplicationStarter.class, args);
	}

}
