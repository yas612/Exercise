package com.q7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude= { DataSourceAutoConfiguration.class} )
public class Q7Application {
	
	public static void main(String[] args) {
	
	SpringApplication.run(Q7Application.class, args);
	
	}

}
