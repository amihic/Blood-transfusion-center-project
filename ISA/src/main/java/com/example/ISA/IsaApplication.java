package com.example.ISA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude =  {DataSourceAutoConfiguration.class })
public class IsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsaApplication.class, args);
	}

}
