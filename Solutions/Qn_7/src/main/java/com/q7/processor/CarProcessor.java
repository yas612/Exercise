package com.q7.processor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.q7.config.CarConfiguration;
import com.q7.model.Car;
import com.q7.model.CarList;




public class CarProcessor implements ItemProcessor<CarList, CarList>{
	private static final Logger log = LoggerFactory.getLogger(CarConfiguration.class);
	@Override
	public CarList process(CarList carList) throws Exception {
		
	List<Car> current=carList.getCurrentFileData();
	List<Car> previous=carList.getPreviousFileData();
	 previous.removeAll(current);
	  carList.setCurrentFileData(previous);
	  log.info(previous.toString());
	 return carList;
	}
}
