package com.yusufbatmaz.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	//Spring Validation'dan alınan hataları kontrol etmek ve response dönmek
	
	//Hataların listesi
	private List<String> addMapValue(List<String> list, String newValue){
		list.add(newValue);
		return list;
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		
		//Hataları daha düzenli göstermek için bir map oluşturalım.
		Map<String, List<String>> errorsMap = new HashMap<>();
		
		for (ObjectError objError : ex.getBindingResult().getAllErrors()) {
			
			//Field isimlerini alabilmek  için:
			String fieldName = ((FieldError)objError).getField();			
			
			//Hataları almak için:
			if (errorsMap.containsKey(fieldName)) { //Öncesinde başka hata varsa(aynı field)
				errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objError.getDefaultMessage()));
			} else {
				errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objError.getDefaultMessage()));
			}		
		}
		return ResponseEntity.badRequest().body(creatApiError(errorsMap));
	}
	
	//<T> -->Generic fonksiyon olduğunu belirtir.
	private <T> ApiError<T> creatApiError(T errors) {
		ApiError<T> apiError = new ApiError<T>();
		apiError.setId(UUID.randomUUID().toString());
		apiError.setErrorTime(new Date());
		apiError.setErrors(errors);
		return apiError;
	}
	
}


















