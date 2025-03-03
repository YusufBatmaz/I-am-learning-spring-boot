package com.yusufbatmaz.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yusufbatmaz.controller.RestEmployeeController;
import com.yusufbatmaz.dto.DtoEmployee;
import com.yusufbatmaz.service.IEmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeControllerImpl implements RestEmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/list/{id}")
	@Override
	public DtoEmployee findEmployeeById(@PathVariable Long id) {
		return employeeService.findEmployeeById(id);
	}

}
