package com.yusufbatmaz.handler;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exception<E> { // Hata mesajlarında daha ayrıntılı bilgi görmek için kullanacağız.

	private String hostName;

	private String path;

	private Date createTime;

	private E messageString;
}
