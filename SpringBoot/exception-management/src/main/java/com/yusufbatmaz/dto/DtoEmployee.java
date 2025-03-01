package com.yusufbatmaz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoEmployee {
	
	private Long id;

	private String name;
	
	private DtoDepartment department;
}
