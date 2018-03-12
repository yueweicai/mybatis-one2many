package com.orilore.mapper;

import com.orilore.model.Person;

public interface PersonMapper {
	public void insert(Person bean);
	public Person selectOne(int id);
}
