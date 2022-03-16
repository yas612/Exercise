package com.q9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication 
@ComponentScan({"com.q9.bat*"})
public class Q9Application {

	public static void main(String[] args) {
		SpringApplication.run(Q9Application.class, args);

	}

}
