package com.yusufbatmaz.services;

import com.yusufbatmaz.dto.DtoCustomer;

public interface ICustomerService {
	
	public DtoCustomer findCustomerById(Long id);

}
