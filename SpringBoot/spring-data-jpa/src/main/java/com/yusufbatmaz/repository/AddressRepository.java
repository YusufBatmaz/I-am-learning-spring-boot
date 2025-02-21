package com.yusufbatmaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yusufbatmaz.entities.Address;

@Repository
@RequestMapping(path = "/rest/api/address")
public interface AddressRepository extends JpaRepository<Address, Long> {

}
