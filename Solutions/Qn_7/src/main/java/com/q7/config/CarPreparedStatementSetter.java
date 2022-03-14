package com.q7.config;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.q7.model.Car;





public class CarPreparedStatementSetter implements ItemPreparedStatementSetter<Car> {

	@Override
	public void setValues(Car car, PreparedStatement ps) throws SQLException {
		ps.setInt(1, car.getId());
		ps.setString(2, car.getName());
		ps.setInt(3, car.getPrice());
		
	}

}