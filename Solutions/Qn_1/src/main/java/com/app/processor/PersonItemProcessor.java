package com.app.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.app.model.Person;



public class PersonItemProcessor implements ItemProcessor<Person,Person>{

	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
	
	
			@Override
	public Person process(Person item) throws Exception {
		 
				int peopleAge = item.getAge();
				if(peopleAge<=25)
					item.setGroup("young");
				if(peopleAge>25 &&  peopleAge<=40)
					item.setGroup("adult");
				if(peopleAge>40)
					item.setGroup("old");
				
				return item;
	}
}
