package com.yusufbatmaz.entities;

import java.util.Date;

import org.apache.el.parser.AstFalse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //getter ve setter olarak 2 kez yazacağımıza @Data olarak da yazabiliriz 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity //Class'ın veritabanında tablo  olarak oluşmasını istiyorum
@Table(name = "STUDENT") //Tablonun adı
public class Student {
	
	@Id //PK olduğnu gösterdik
	@Column(name = "id") //Sütunun adını belirtik
	//Kendi kendine artması için kullanılır 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "firs_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "birth_of_date", nullable = true)
	private Date birthOfDate;
}
