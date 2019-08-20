package com.jrbrayjr.poc.soap;

import org.jdom2.input.SAXBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PocSoapProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocSoapProcessorApplication.class, args);
	}

	@Bean
	public SAXBuilder saxBuilder() {
		SAXBuilder saxBuilder = new SAXBuilder();
		return saxBuilder;
	}

}
