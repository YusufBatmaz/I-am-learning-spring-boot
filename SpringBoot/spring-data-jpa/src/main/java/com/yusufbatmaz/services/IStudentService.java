package com.yusufbatmaz.services;

import java.util.List;

import com.yusufbatmaz.dto.DtoStudent;
import com.yusufbatmaz.dto.DtoStudentIU;
import com.yusufbatmaz.entities.Student;

public interface IStudentService {
	
	public DtoStudent saveStudent(DtoStudentIU student);
	
	public List<DtoStudent> getAllStudents(); //Student listesini döndürür.
	
	public DtoStudent getStudentById(Integer id);  //Id'ye göre student getirecek
	
	public void deleteStudentById(Integer id); //Id'ye göre student sil
	
	public DtoStudent updateStudent(Integer id ,DtoStudentIU dtoStudentIU); //Id'ye göre student güncelle(save mettodu kullanılarak üzerine yazılacak)
}
