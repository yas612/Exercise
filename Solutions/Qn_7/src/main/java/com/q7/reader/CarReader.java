package com.q7.reader;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.q7.config.CarConfiguration;
import com.q7.model.*;

public class CarReader implements ItemReader<CarList>{

	private static final Logger log = LoggerFactory.getLogger(CarConfiguration.class);
	
	CarList carList=new CarList();
	
	private boolean isRead=false;
	
	@Override
	public CarList read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		if(isRead)
		{
			return null;
		}
	
   Stream<String> mappingStream=Files.lines(Paths.get("C:\\Users\\MOHOLI\\Documents\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\Qn_7\\target\\classes\\input\\input2.csv"),StandardCharsets.UTF_8 );
   List<String> currentList=mappingStream.collect(Collectors.toList());
   List<Car> CarCurrentList=new ArrayList<>();
    
   int counter=0;
   int counterTwo=0;
    
   for(String item : currentList)
   {
	   
	   counter++;
	   if(counter!=1)
	   {
		   log.info(item);
		   String[] currentArray=item.split("\\,");
		   Car car=new Car();
		   car.setId(Integer.parseInt(currentArray[0]));
		   car.setName(currentArray[1]);
		   car.setPrice(Integer.parseInt(currentArray[2]));
		   CarCurrentList.add(car);
		 
	   }
   }
   
   carList.setCurrentFileData(CarCurrentList);
   
   mappingStream=Files.lines(Paths.get("C:\\\\Users\\\\MOHOLI\\\\Documents\\\\workspace-spring-tool-suite-4-4.12.1.RELEASE\\\\Qn_7\\\\target\\\\classes\\\\input\\\\input1.csv"),StandardCharsets.UTF_8 );
   List<String> previousList=mappingStream.collect(Collectors.toList());
   List<Car> CarPreviousList=new ArrayList<>();
   
   for(String item : previousList)
   {
	   
	   counterTwo++;
	   if(counterTwo!=1)
	   {
		   log.info(item);
		   String[] previousArray=item.split("\\,");
		   Car car=new Car();
		   car.setId(Integer.parseInt(previousArray[0]));
		   car.setName(previousArray[1]);
		   car.setPrice(Integer.parseInt(previousArray[2]));
		   CarPreviousList.add(car);
		   
	   }
   }
    carList.setPreviousFileData(CarPreviousList);
    isRead=true;
	return carList;
	}
}