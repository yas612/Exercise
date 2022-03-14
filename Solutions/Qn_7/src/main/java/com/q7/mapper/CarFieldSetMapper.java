package com.q7.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.q7.model.Car;



public class CarFieldSetMapper implements FieldSetMapper<Car> {

	@Override
	public Car mapFieldSet(FieldSet fieldSet) throws BindException {

		Car car =  new Car();
		car.setId(fieldSet.readInt("id"));
		car.setName(fieldSet.readString("name"));
		car.setPrice(fieldSet.readInt("price"));
		
		return car;
	}

}
