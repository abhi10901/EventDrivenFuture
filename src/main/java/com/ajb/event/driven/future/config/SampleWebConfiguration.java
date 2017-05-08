package com.ajb.event.driven.future.config;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan
public class SampleWebConfiguration 
		extends WebMvcConfigurerAdapter {
	
//	@Bean
//	public HttpMessageConverters customConverters() {
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		converter.setPrettyPrint(true);
//		//converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/json"));
//		//converter.setObjectMapper(new ObjectMapper());
//		
//		return new HttpMessageConverters(converter);
//	}

}
