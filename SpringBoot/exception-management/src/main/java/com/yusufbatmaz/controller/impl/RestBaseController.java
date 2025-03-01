package com.yusufbatmaz.controller.impl;

import com.yusufbatmaz.model.RootEntity;

public class RestBaseController { // Tüm controller'ların atası gibi düşünebiliriz.

	public static <T> RootEntity<T> ok(T data) {
		return RootEntity.ok(data);
	}

	public static <T> RootEntity<T> error(String errorMessage) {
		return RootEntity.error(errorMessage);
	}
}
