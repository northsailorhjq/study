package com.springbootdemo5.service;

import com.springbootdemo5.domain.Person;

public interface PersonService {
	public Person savePersonWithRollBack(Person person);
	public Person savePersonWithoutRollBack(Person person);

}
