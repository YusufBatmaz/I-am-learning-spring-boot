package com.yusufbatmaz.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component // Spring tarafından bu sınıfın bir bileşen (bean) olarak yönetilmesini sağlar.
@Data
//app.properties dosyasından veri almak için kullanacağım.
public class GlobalProperties {

	@Value("${spring.datasource.url}") // app.properties içindeki "spring.datasource.url" değerini alır. Ve url
										// değişkenine atar.
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;
}
