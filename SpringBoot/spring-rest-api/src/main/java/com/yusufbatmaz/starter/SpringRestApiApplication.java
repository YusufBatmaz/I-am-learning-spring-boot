package com.yusufbatmaz.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/*com.yusufbatmaz içindeki  her şeyi tara ve component anotasyonuyla işaretli olan veya
component anotasyonunu extent etmiş sınıfları bul ve onların spring coontextte bean'lerinin
oluşmasını sağla*/
@ComponentScan(basePackages = {"com.yusufbatmaz"} )
@SpringBootApplication
public class SpringRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiApplication.class, args);
	}

}
