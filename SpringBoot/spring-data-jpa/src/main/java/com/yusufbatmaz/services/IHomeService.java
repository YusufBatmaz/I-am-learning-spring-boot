package com.yusufbatmaz.services;

import com.yusufbatmaz.dto.DtoHome;

public interface IHomeService {
	
	public DtoHome findHomeById(Long id);
}
