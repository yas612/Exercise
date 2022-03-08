package com.q4.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.q4.model.Bike;





public class BikeItemProcessor implements ItemProcessor<Bike,Bike>{

	private static final Logger log = LoggerFactory.getLogger(BikeItemProcessor.class);
	
	
			@Override
	public Bike process(Bike item) throws Exception {
		 
		
		  int bikeSpeed = item.getSpeed(); 
		  if(bikeSpeed>=100) {
		  log.info("Over speed may cause accident, hence not allowed");
		  return null;
		  
		  
		  }
		  
		  log.info(item.toString());
		  
		 
				
				return item;
	}
}



