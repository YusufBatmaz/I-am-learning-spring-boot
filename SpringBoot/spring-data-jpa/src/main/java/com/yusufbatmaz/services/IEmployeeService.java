package com.yusufbatmaz.services;

import java.util.List;

import com.yusufbatmaz.dto.DtoEmployee;

public interface IEmployeeService {

	public List<DtoEmployee> findAllEmployees();
}
