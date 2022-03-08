package com.q4.config;





import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.q4.mapper.BikeRowMapper;
import com.q4.model.Bike;
import com.q4.processor.BikeItemProcessor;
import com.q4.reader.BikeReader;
import com.q4.writer.BikeWriter;
import com.q4.listener.BikeChunkCounter;


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
	    public JdbcCursorItemReader<Bike> reader(){
			JdbcCursorItemReader<Bike> cursorItemReader = new JdbcCursorItemReader<>();
			cursorItemReader.setDataSource(dataSource);
			cursorItemReader.setSql("SELECT * FROM bike");
			cursorItemReader.setRowMapper(new BikeRowMapper());
			return cursorItemReader;
		}
	     
	     @Bean
	 	public BikeItemProcessor processor(){
	 		return new BikeItemProcessor();
	 	}
	 
	
	@Bean
	public StaxEventItemWriter<Bike> writer(){
	   return new BikeWriter().writer();
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
