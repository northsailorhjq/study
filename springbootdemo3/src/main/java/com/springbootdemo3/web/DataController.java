package com.springbootdemo3.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo3.dao.PersonDao;
import com.springbootdemo3.domain.Person;

@RestController
public class DataController {
	@Autowired
	PersonDao personDao;
	@RequestMapping("/")
	public String hello(){
		return "hello world";
		
	}
	@RequestMapping("/save")
	public Person save(String name,Integer age,String address){
		Person p=personDao.save(new Person(null, name, age, address));
		return p;
	}
	@RequestMapping("/findAll")
	public List<Person> findAll(){
		return personDao.findAll();		
	}
	@RequestMapping("/q1")
	public Person q1(String name,String address){
		return personDao.withNameAndAddressNamedQuery(name, address);
	}
	@RequestMapping("/q2")
	public Person q2(String name,String address){
		return personDao.findByNameAndAddress(name, address);
	}
	@RequestMapping("/q3")
	public Person q3(String name,String address){
		return personDao.findByNameAndAddress(name, address);
	}
	@RequestMapping("/q4")
	public Person q4(String name,String address){
		return personDao.findByNameAndAddress(name, address);
	}
	@RequestMapping("/sort")
	public List<Person> sort(){
		return personDao.findAll(new Sort(Direction.ASC, "age"));
	}
	@RequestMapping("/page")
	public Page<Person> page(){
		return personDao.findAll(new PageRequest(1, 2));
	}
}
