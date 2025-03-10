package com.yusufbatmaz.controller;

import java.util.List;

import com.yusufbatmaz.dto.DtoStudent;
import com.yusufbatmaz.dto.DtoStudentIU;
import com.yusufbatmaz.entities.Student;

public interface IStudentController {
	
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	
	public List<DtoStudent> getAllStudents();
	
	public DtoStudent getStudentById(Integer id);
	
	public void deleteStudentById(Integer id);
	
	public DtoStudent updateStudent(Integer id ,DtoStudentIU dtoStudentIU);
}
