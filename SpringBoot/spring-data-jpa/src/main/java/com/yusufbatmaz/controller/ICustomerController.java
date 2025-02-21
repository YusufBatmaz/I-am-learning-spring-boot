package com.yusufbatmaz.controller;

import com.yusufbatmaz.dto.DtoCustomer;

public interface ICustomerController {
	
	public DtoCustomer findCustomerById(Long id);

}
