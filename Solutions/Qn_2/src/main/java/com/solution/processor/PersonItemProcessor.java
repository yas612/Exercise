package com.solution.processor;

import com.solution.model.Person;

import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person>{

	@Override
	public Person process(Person person) throws Exception {
		String valage = person.getName();
		
		if(valage.startsWith("s"))
		{
			return null;
		}
		return person;
	}
}