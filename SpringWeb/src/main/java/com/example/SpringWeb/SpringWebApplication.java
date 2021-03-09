package com.example.SpringWeb;

import com.example.SpringWeb.domain.Customer;
import com.example.SpringWeb.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
//import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.*;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

@SpringBootApplication
public class SpringWebApplication {//implements CommandLineRunner{


	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CustomerService customerService){
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
			try {
				List<Customer> users = mapper.readValue(inputStream,typeReference);
				customerService.save(users);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Customers: " + e.getMessage());
			}
		};
	}
	/*
	@Override
	public void run(String[] args) throws IOException {
		String text="";
		try{
			File resource = ResourceUtils.getFile("classpath:customer.json");
			text = new String(Files.readAllBytes(resource.toPath()));



		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		//read json file and convert to customer object
		Customer cust = objectMapper.readValue(resource, Customer.class);

		//print customer details
		System.out.println(cust.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	*/
}
