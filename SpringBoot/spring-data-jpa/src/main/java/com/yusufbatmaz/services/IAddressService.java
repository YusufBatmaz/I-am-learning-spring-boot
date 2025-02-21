package com.yusufbatmaz.services;

import com.yusufbatmaz.dto.DtoAddress;

public interface IAddressService {
	
	public DtoAddress findAddressById(Long id);
}
