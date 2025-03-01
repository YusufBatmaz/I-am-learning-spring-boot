package com.yusufbatmaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yusufbatmaz.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
