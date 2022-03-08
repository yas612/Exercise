package com.app.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.app.model.Person;

public class PersonFieldSetMapper implements FieldSetMapper<Person> {

	@Override
	public Person mapFieldSet(FieldSet fieldSet) throws BindException {

		Person person =  new Person();
		person.setId(fieldSet.readInt("id"));
		person.setName(fieldSet.readString("name"));
		person.setAge(fieldSet.readInt("age"));
		person.setGroup(fieldSet.readString("group"));

		return person;
	}

}
