package com.yusufbatmaz.handler;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.yusufbatmaz.exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { BaseException.class })
	public ResponseEntity<ApiError> handleBaseException(BaseException exception, WebRequest request) {
		return ResponseEntity.badRequest().body(createApiError(exception.getMessage(), request));
	}

	private String getHostName() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			System.out.println("Hata oluştu!" + e.getMessage());
		}
		return null;
	}

	public <E> ApiError<E> createApiError(E message, WebRequest request) {

		ApiError<E> apiError = new ApiError<E>();
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());

		Exception<E> exception = new Exception<E>();
		exception.setCreateTime(new Date(0));
		exception.setHostName(getHostName());
		exception.setPath(request.getDescription(false).substring(4));
		exception.setMessageString(message);

		apiError.setException(exception);

		return apiError;

	}
}
