package com.yusufbatmaz.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.stereotype.Repository;

import com.yusufbatmaz.model.Employee;
import com.yusufbatmaz.model.UpdateEmployeeRequest;

@Repository
public class EmployeeRepository {
	
	@Autowired //Congig'de contexte tanımladığımız Employee'yi Repository'de kullanmak istiyorum 
	private List<Employee> employeeList;
	
	public List<Employee> getAllEmployeeList(){
		//Veriyi bir geri katman olan servis döndürür
		return employeeList;
	}
	
	//aranan bi  id'deki employee'yi bulmak
	public Employee getEmployeeById(String  id) {
		Employee findEmployee = null;
	    for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				findEmployee =employee;
				break;
			}
		}
		return findEmployee;
	}
	
	
	//Elimizde şuanlık DB olmadığı için listeye ekleme işlemlerini aşağıdaki gibi yapmak  zorundayız.
	public List<Employee> getEmployeeWithParams(String firstName, String lastName){
		List<Employee> employeeWithParams = new ArrayList<>();
		// Hiçbir  şey yazılmazsa tüm listeyi getir 
		if (firstName==null && lastName==null) {
			return employeeList;
		}
		for (Employee employee : employeeList) {
			//Hem firstName hem lastName girilmişse büyük harfe dikkat etmeksizin uyuşan isim veya isimleri getirir. 
			if (firstName!=null && lastName!=null) {
				//equalsIgnoreCase ile büyük küçük harfe dikkat edilmez A ve a aynıdır
				if (employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);
				}
			}
			//sadece firstName girilen ve uyuşan isim gelir
			if (firstName!=null && lastName==null) {
				if (employee.getFirstName().equalsIgnoreCase(firstName)) {
					employeeWithParams.add(employee);
				}
			}
			//sadece lastName girilen ve uyuşan isim gelir
			if (firstName==null && lastName!=null) {
				if (employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);
					}	
			   }	
		}
		return employeeWithParams;		
	}
	
	//Dışarıdan gelen yeni veriyi listeye eklemek  için yazdık
	public Employee saveEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);
		return newEmployee;
	}
	
	//Listeden veri silmek için kullanılan method
	public boolean deleteEmployee(String id) {
		
		Employee deleteEmployee =null;
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				deleteEmployee = employee;
				break;
			}	
		}
		if (deleteEmployee == null) {
			return false;
		}
		employeeList.remove(deleteEmployee);
		return true;
	}
	
	
	//Aranan öğeyi bulmak  için fonksiyon
	private Employee findEmployeeById(String id) {
		Employee findEmployee = null;
		for (Employee employee : employeeList) {
			if (employee.getId().equals(id)) {
				findEmployee = employee;
				break;   				
			}
		}
		return findEmployee;
	}
	
	//Eski değeri silip yeni değerle güncellemek için kullanlacak  method
	public Employee updateEmployee(String id, UpdateEmployeeRequest request) {
		Employee finEmployee = findEmployeeById(id);
		if (finEmployee != null) {
			deleteEmployee(id);   //Veri silmek için yazdığımız bir fonksiyon
			
			Employee updatedEmployee = new Employee();
			updatedEmployee.setId(id);
			updatedEmployee.setFirstName(request.getFirstName());
			updatedEmployee.setLastName(request.getLastName());
			
			employeeList.add(updatedEmployee);
			return updatedEmployee;
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	

