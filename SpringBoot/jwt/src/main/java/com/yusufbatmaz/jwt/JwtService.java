package com.yusufbatmaz.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

	public static final String SECRET_KEY = "XNlO4DHBKi9BbCJCcinISjVyQn+MvEFyH+l6ZAD+ttw=";

	// Token oluşturmak için kullanılacak
	public String generateToken(UserDetails userDetails) {
		
		Map<String, String> claimsMap = new HashMap<>();
		claimsMap.put("role", "ADMIN");
			
		return Jwts.builder()
		.setSubject(userDetails.getUsername())
		.setClaims(claimsMap)
		.setIssuedAt(new Date()) //  Token'ın başlangıç vakti
		.setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*2)) //  Milisaniye cinsinden Token'ın geçerlilik süresi 2 saat
		.signWith(getKey(), SignatureAlgorithm.HS256)     // Token oluşturup çözeceği key
		.compact();
		
	}
	
	// Tokenı çözecek method
	public <T> T exportToken(String token, Function<Claims, T> claimsFunction) {
		Claims claims = (Claims) Jwts.parserBuilder().setSigningKey(getKey()).build().parse(token).getBody();

		return claimsFunction.apply(claims);
	}

	// Token içinden kullanıcı adı almak
	public String getUserNameByToken(String token) {
		return exportToken(token, Claims::getSubject);
	}
	
	// Token expireoldu mu, olmadı mı?
	public Boolean isTokenExpired(String token) {
		Date expiredDate= exportToken(token, Claims::getExpiration);
		
		return new Date().before(expiredDate); // Şuanki tarih bitiş  süresinden küçükçe hala aktiftir(true) döner
	}
	
	// SECRET_KEY i  kullanarak bir anahtar oluşturur ve key tipinde geriye döndürür
	public Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
