package com.yusufbatmaz.controller;

import com.yusufbatmaz.dto.DtoAddress;

public interface IAddressController {

	public DtoAddress findAddressById(Long id);

}
