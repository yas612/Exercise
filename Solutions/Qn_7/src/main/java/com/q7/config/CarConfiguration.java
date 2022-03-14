package com.q7.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.q7.listener.CarCounter;
import com.q7.model.CarList;
import com.q7.processor.CarProcessor;
import com.q7.reader.CarReader;
import com.q7.writer.CarWriter;






@Configuration
@EnableBatchProcessing
public class CarConfiguration {
	@Value("classpath:input/input*.csv")
	private Resource[] resource;

	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public CarCounter listener()
	{
		return new CarCounter();
	}

	

	public Step step1(){
		return stepBuilderFactory.get("step1")
				.<CarList, CarList>chunk(3)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.listener(listener())
				.build();
	}

	@Bean
	public Job exportPersonJob(){
		return jobBuilderFactory.get("exportPeronJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end().build();
	}
	
	@Bean
	public CarReader reader()
	{
		return new CarReader();
	}
	
	@Bean
	public CarProcessor processor()
	{
		return new CarProcessor();
	}
	
	@Bean
	public CarWriter writer()
	{
		return new CarWriter();
	}
	
}