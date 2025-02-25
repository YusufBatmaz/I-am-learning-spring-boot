package com.yusufbatmaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yusufbatmaz.entities.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

}
