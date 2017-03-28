package com.springbootdemo4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.springbootdemo4.domain.Person;

public interface PersonDao extends JpaRepository<Person, Long>{
	
	Person withNameAndAddressNamedQuery(String name,String address);
	
	Person findByNameAndAddress(String name,String address);
	@Query("select p from Person p where p.name= :name and p.address= :address")
	Person withNameAndAddress(@Param("name")String name,@Param("address")String address);
	@RestResource(path="nameStartsWith",rel="nameStartsWith")
	Person findByNameStartsWith(@Param("name")String name);
}


