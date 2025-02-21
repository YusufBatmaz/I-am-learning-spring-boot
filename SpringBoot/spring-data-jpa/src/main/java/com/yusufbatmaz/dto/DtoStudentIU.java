package com.yusufbatmaz.dto;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
	
	@NotEmpty(message = "Firstname alanı boş olamaz.")
	@Max(value = 20, message = "Firstname uunluğu maksimum 20 olabilir.")
	@Min(value = 2, message = "Firstname uunluğu minimum 2 olabilir.")
	private String firstName;
	
	@Size(min = 2, max = 20)
	private String lastName;
	
	private Date birthOfDate;
}
