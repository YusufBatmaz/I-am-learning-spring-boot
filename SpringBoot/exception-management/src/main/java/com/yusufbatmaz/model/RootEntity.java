package com.yusufbatmaz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RootEntity<T> { // Tek bir formatta response dönmek için kullanacağız

	// Servs başarılı çalıştı mı, bir problem var mı?
	private Boolean result;

	// result = false olursa (başarısız)
	private String errorMessage;

	// result = true ise
	private T data;

	public static <T> RootEntity<T> ok(T data) {// Başarılı sonuç için method
		RootEntity<T> rootEntity = new RootEntity<>();
		rootEntity.setData(data);
		rootEntity.setResult(true);
		rootEntity.setErrorMessage(null);
		return rootEntity;
	}

	public static <T> RootEntity<T> error(String errorMessage) {// Başarısız sonuç için method
		RootEntity<T> rootEntity = new RootEntity<>();
		rootEntity.setData(null);
		rootEntity.setResult(false);
		rootEntity.setErrorMessage(errorMessage);
		return rootEntity;
	}
}
