package com.yusufbatmaz.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yusufbatmaz.dto.DtoDepartment;
import com.yusufbatmaz.dto.DtoEmployee;
import com.yusufbatmaz.exception.BaseException;
import com.yusufbatmaz.exception.ErrorMessage;
import com.yusufbatmaz.model.Department;
import com.yusufbatmaz.model.Employee;
import com.yusufbatmaz.repository.EmployeeRepository;
import com.yusufbatmaz.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public DtoEmployee findEmployeeById(Long id) {

		DtoEmployee dtoEmployee = new DtoEmployee();
		DtoDepartment dtoDepartment = new DtoDepartment();

		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(com.yusufbatmaz.exception.MessageType.NO_RECORD_EXIST, id.toString()));
		}
		Employee employee = optional.get();
		Department department = employee.getDepartment();

		BeanUtils.copyProperties(employee, dtoEmployee);
		BeanUtils.copyProperties(department, dtoDepartment);

		dtoEmployee.setDepartment(dtoDepartment);

		return dtoEmployee;
	}

}
