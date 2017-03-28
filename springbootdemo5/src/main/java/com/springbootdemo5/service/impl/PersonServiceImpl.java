package com.springbootdemo5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootdemo5.dao.PersonDao;
import com.springbootdemo5.domain.Person;
import com.springbootdemo5.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonDao personDao;
	@Override
	@Transactional(rollbackFor={IllegalArgumentException.class})
	public Person savePersonWithRollBack(Person person) {
		Person p=personDao.save(person);
		if (person.getName().equals("hjq")) {
			throw new IllegalArgumentException("hjq已存在，数据将会滚");
		}
		return p;
	}
	@Override
	@Transactional(noRollbackFor={IllegalArgumentException.class})
	public Person savePersonWithoutRollBack(Person person) {
		Person p=personDao.save(person);
		if (person.getName().equals("hjq")) {
			throw new IllegalArgumentException("hjq虽已存在，数据将会滚");
		}
		return p;
	}

	
}
