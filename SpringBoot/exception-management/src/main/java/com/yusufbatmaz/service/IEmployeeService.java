package com.yusufbatmaz.service;

import com.yusufbatmaz.dto.DtoEmployee;

public interface IEmployeeService {

	public DtoEmployee findEmployeeById(Long id);
}
