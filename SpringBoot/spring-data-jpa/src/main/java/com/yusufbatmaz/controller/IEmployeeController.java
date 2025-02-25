package com.yusufbatmaz.controller;

import java.util.List;

import com.yusufbatmaz.dto.DtoEmployee;

public interface IEmployeeController {
	
	public List<DtoEmployee> findAllEmployees();
}
