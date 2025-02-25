package com.yusufbatmaz.controller;

import com.yusufbatmaz.dto.DtoHome;

public interface IHomeController {
	
	public DtoHome findHomeById(Long id);
}
