package com.dataprocessingpipeline.dataaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = "com.dataprocessingpipeline.dataaccess")
@PropertySource(value = "data.properties")
public class DataAccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataAccessApplication.class, args);
	}

}
