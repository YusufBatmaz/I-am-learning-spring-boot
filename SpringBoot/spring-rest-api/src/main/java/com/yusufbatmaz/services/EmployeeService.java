package com.yusufbatmaz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yusufbatmaz.model.Employee;
import com.yusufbatmaz.model.UpdateEmployeeRequest;
import com.yusufbatmaz.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee>getAllEmployeeList(){
		
		//Repository'den aldığı veriyi controller katmanına döndürür
		return employeeRepository.getAllEmployeeList();		
	}
	
	//Repository'de aranıp bulunan employee Sevice katmanına çekilir
	public Employee getEmployeeById(String id) {
		return employeeRepository.getEmployeeById(id);
	}
	
	//Aranan ifadenin controller'dan Repository katmanına geçişi
	public List<Employee> getEmployeeWithParams(String firstName, String lastName){
		return employeeRepository.getEmployeeWithParams(firstName,lastName);
	}
	
	
	//Eklenen employee'yi repository katmanındaki saveEmployee metoduna taşır
	public Employee saveEmployee(Employee newEmployee) {
		return employeeRepository.saveEmployee(newEmployee);
	}
	
	//Gelen id'yi employeeRepository içindeki deleteEmployee() metoduna taşır
	public boolean deleteEmployee(String id) {
		return employeeRepository.deleteEmployee(id);
	}
	
	//Güncellenen veri için repository-controller köprüsü
	public Employee updateEmployee(String id, UpdateEmployeeRequest request) {
		return employeeRepository.updateEmployee(id, request);
		
	}

}
