package com.yusufbatmaz.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//property dosyasından ip ve location bilgilerini bu class'a akatarıyorum.
public class Server {
	
	private String ip;
	
	private String location;
}
