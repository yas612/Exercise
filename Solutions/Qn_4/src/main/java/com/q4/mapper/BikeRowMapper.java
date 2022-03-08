package com.q4.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.validation.BindException;

import com.q4.model.Bike;




public class BikeRowMapper implements RowMapper<Bike> {

	@Override
	public Bike mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bike bike = new Bike();
		bike.setId(rs.getInt("id"));
		bike.setName(rs.getString("name"));
		bike.setSpeed(rs.getInt("speed"));
		return bike;
	}

}