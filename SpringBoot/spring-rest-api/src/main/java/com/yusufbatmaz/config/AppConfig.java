package com.yusufbatmaz.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yusufbatmaz.model.Employee;

@Configuration //Konfigirasyon sınıfı olduğu için bu şekilde işaretledik
public class AppConfig {
	
	@Bean //Spring Contextte bir bean oluşturduk
	public List<Employee> employeeList(){
		//Şu an için DB bulunmadığı için veriyi burda oluşturacağız 
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("1", "Yusuf", "Batmaz"));
		employeeList.add(new Employee("2", "A", "X"));
		employeeList.add(new Employee("3", "B", "Y"));
		employeeList.add(new Employee("4", "C", "Z"));
		employeeList.add(new Employee("5", "D", "W"));
		
		return employeeList;

		
	}

}
