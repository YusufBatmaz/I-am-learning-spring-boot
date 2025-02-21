package com.yusufbatmaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yusufbatmaz.entities.Student;

      								//Hibernate tarafında var olan hazır fonksiyonları kullanmak için bu bağlantıyı oluşturacağız.
									//Hazır olan crud işlemlerini gerçekleştirmemize olanak sağlayacak.
									//T-->Üzerinde işlem yapacağı sınıf
@Repository							//ID-->PK olan kolonun veri tipi
public interface Studentrepository extends JpaRepository<Student, Integer> {

}
