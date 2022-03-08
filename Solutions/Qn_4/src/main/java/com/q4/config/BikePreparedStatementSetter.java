package com.q4.config;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.q4.model.Bike;



public class BikePreparedStatementSetter implements ItemPreparedStatementSetter<Bike> {

	@Override
	public void setValues(Bike bike, PreparedStatement ps) throws SQLException {
		ps.setInt(1, bike.getId());
		ps.setString(2, bike.getName());
		ps.setInt(3, bike.getSpeed());
		
	}

}