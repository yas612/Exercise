package com.q3.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.q3.model.Bike;

public class BikeFieldSetMapper implements FieldSetMapper<Bike> {

	@Override
	public Bike mapFieldSet(FieldSet fieldSet) throws BindException {

		Bike bike = new Bike();
		bike.setId(fieldSet.readInt("id"));
		bike.setName(fieldSet.readString("name"));
		bike.setSpeed(fieldSet.readInt("speed"));

		return bike;
	}

}