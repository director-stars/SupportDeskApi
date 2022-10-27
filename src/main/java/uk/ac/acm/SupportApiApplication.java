package uk.ac.acm;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
@EnableCaching
public class SupportApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SupportApiApplication.class, args);
	}
	@Bean
	public ObjectMapper mapper() {
		 ObjectMapper objectMapper = new ObjectMapper();
	        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	        objectMapper.setDateFormat(df);
	        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
	        objectMapper.setSerializationInclusion(Include.NON_NULL);
	        return objectMapper;
	}
	

}
