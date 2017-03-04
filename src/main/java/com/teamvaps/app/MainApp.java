package com.teamvaps.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.teamvaps.app.configuration.JpaConfig;

@Import(JpaConfig.class)
@SpringBootApplication
@ComponentScan("com.teamvaps.app")
public class MainApp {

	public static void main(String[] args) {
	    SpringApplication.run(MainApp.class, args);
	  }  
}