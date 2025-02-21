package com.yusufbatmaz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yusufbatmaz.model.Employee;
import com.yusufbatmaz.model.UpdateEmployeeRequest;
import com.yusufbatmaz.services.EmployeeService;

@RestController
@RequestMapping("/rest/api/employee") //Dışarıdan gelen isteklerde kök adres tanımlaması yapılır
public class RestEmployeeController {
	
	@Autowired //Controller ve Service katmanları arasında enjekte yapmak için kullanıldı
	private EmployeeService employeeService;
	
	@GetMapping(path = "/list")// get isteği  olduğu için bu anotasyon kullanılır
	public List<Employee> getAllEmployeeList(){
		
		//Servis katmanına geçiş
		return employeeService.getAllEmployeeList();
	}
	
	/*Postman'da girdiğimiz yolda id değerini alır ve @PathVariable id'yi  id değişkenine atar böylelikle 
	repository kısmında gerçekleşen arama işlemi  gerçekleşebilir(tek tek enjekte olarak repository'ye ulaşacak) */
	@GetMapping(path = "/list/{id}")
	public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id) {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping(path = "/with-params")
	//Filtreli arama yapmak için @RequestParam anotasyonu kullanılır.
	public List<Employee> getEmployeeWithParams(@RequestParam(name="firstName", required = false) String firstName,
												@RequestParam(name="lastName", required = false) String lastName) {
		return employeeService.getEmployeeWithParams(firstName, lastName);
		
	}
	
	//@PostMapping post servisi geliştirdiğimizi  ifade eder
	//(@RequestBody dışarıdan değer alıp  kaydetmeye yarar
	@PostMapping(path = "/save-employee")
	public Employee saveEmployee(@RequestBody Employee newEmployee) {
		return employeeService.saveEmployee(newEmployee);
	}
	
	//@DeleteMapping bu methodun silme işlemi yapacağını belirten anotosayondur
	//Tipi boolean verdik çünkü sildiğimizde true, silemediğimizde false döndürmesini istiyoruz
	@DeleteMapping(path = "/delete-employee/{id}")
	public boolean deleteEmployee(@PathVariable(name = "id") String id) {
		return employeeService.deleteEmployee(id);
	}
	
	//@PutMapping bu methodun güncelleme işlemi yapacağını belirten anotosayondur
	@PutMapping(path = "/update-employee/{id}")
	public Employee updateEmployee(@PathVariable(name = "id") String id, @RequestBody UpdateEmployeeRequest request) {
		return employeeService.updateEmployee(id, request);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
