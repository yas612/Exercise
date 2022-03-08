package com.q3.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;


import com.q3.model.Bike;
import com.q3.processor.BikeItemProcessor;
import com.q3.listener.BikeChunkCounter;




@Configuration
@EnableBatchProcessing
public class BikeConfiguration {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public BikeChunkCounter listener() {
		return new BikeChunkCounter();
	}
	
	@Bean
	public BikeItemProcessor processor(){
		return new BikeItemProcessor();
	}
	
	 @Bean
	 public StaxEventItemReader<Bike> reader(){
	  StaxEventItemReader<Bike> reader = new StaxEventItemReader<Bike>();
	  reader.setResource(new ClassPathResource("bikes.xml"));
	  reader.setFragmentRootElementName("Bike");
	  
	  Map<String, String> aliases = new HashMap<String, String>();
	  aliases.put("Bike", "com.q3.model.Bike");
	  
	  XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
	  xStreamMarshaller.setAliases(aliases);
	  
	  reader.setUnmarshaller(xStreamMarshaller);
	  
	  return reader;
	 }
	
	@Bean
	public JdbcBatchItemWriter<Bike> writer(){
		JdbcBatchItemWriter<Bike> writer = new JdbcBatchItemWriter<Bike>();
		writer.setDataSource(dataSource);
		writer.setSql("INSERT INTO bike(id,name,speed) VALUES(?,?,?)");
		writer.setItemPreparedStatementSetter(new BikePreparedStatementSetter());
		return writer;
	}
	
	@Bean
	public Step step1(){
		return stepBuilderFactory.get("step1").<Bike,Bike>chunk(2).reader(reader()).processor(processor()).writer(writer())
				.listener(listener())
				.build();
	}

	@Bean
	public Job exportPerosnJob(){
		return jobBuilderFactory.get("importbikeJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
	}
}
