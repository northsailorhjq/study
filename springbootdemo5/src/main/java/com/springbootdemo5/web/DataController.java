package com.springbootdemo5.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo5.domain.Person;
import com.springbootdemo5.service.PersonService;

@RestController
public class DataController {
	@Autowired
	private PersonService  personService;
	@RequestMapping("/rollback")
	public Person rollback(Person person){
		return personService.savePersonWithRollBack(person);
	}
	@RequestMapping("/norollback")
	public Person norollback(Person person){
		return personService.savePersonWithoutRollBack(person);
	}
}
