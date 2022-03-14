package com.q7.writer;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.ClassPathResource;

import com.q7.config.CarConfiguration;
import com.q7.model.Car;
import com.q7.model.CarList;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CarWriter implements ItemWriter<CarList>{

	private static final Logger log = LoggerFactory.getLogger(CarConfiguration.class);
	
	@Override
	public void write(List<? extends CarList> items) throws Exception {
		List<Car> aboveFifty=new ArrayList<Car>();
		List<Car> belowFifty=new ArrayList<Car>();
		
		log.info("Cars:", items);
		
		for(CarList item : items)
		{
			for(Car car : item.getCurrentFileData())
			{
				if(car.getPrice()<50000)
				{
					
					belowFifty.add(car);
					
				} else if(car.getPrice()>50000)
				{
					car.setReason("price");
					
					aboveFifty.add(car);
					
				}
			}
			
			
		}
		
		
	FlatFileItemWriter<Car> successWriter=new FlatFileItemWriter<Car>();
	String file = "output/success.csv";
        successWriter.setResource(new ClassPathResource(file));
        successWriter.setAppendAllowed(true);

        DelimitedLineAggregator<Car> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(",");

        BeanWrapperFieldExtractor<Car> fieldExtractor = new BeanWrapperFieldExtractor<>();
        fieldExtractor.setNames(Car.getFields());

        lineAggregator.setFieldExtractor(fieldExtractor);
        successWriter.setLineAggregator(lineAggregator);
        successWriter.open(new ExecutionContext());
        
        successWriter.write(belowFifty);
        successWriter.setEncoding("UTF-8");
        successWriter.close();
        
        FlatFileItemWriter<Car> rejectWriter=new FlatFileItemWriter<Car>();
	String rejectFile = "output/failure.csv";
        rejectWriter.setResource(new ClassPathResource(rejectFile));
        rejectWriter.setAppendAllowed(true);

        DelimitedLineAggregator<Car> lineAggregatorReject = new DelimitedLineAggregator<>();
        lineAggregatorReject.setDelimiter(",");

        BeanWrapperFieldExtractor<Car> fieldExtractorReject = new BeanWrapperFieldExtractor<>();
        fieldExtractorReject.setNames(Car.getFields());

        lineAggregatorReject.setFieldExtractor(fieldExtractorReject);
        rejectWriter.setLineAggregator(lineAggregatorReject);
        rejectWriter.open(new ExecutionContext());
        
        rejectWriter.write(aboveFifty);
        rejectWriter.setEncoding("UTF-8");
        rejectWriter.close();
		
	}
   
}
