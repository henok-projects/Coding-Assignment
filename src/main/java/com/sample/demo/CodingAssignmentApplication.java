package com.sample.demo;

import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sample.demo.domains.Child;
import com.sample.demo.domains.Parent;
import com.sample.demo.services.ChildService;
import com.sample.demo.services.ParentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CodingAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingAssignmentApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(ParentService parentService){
		return args -> {
			// read JSON Array and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Parent>> typeReference = new TypeReference<List<Parent>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Parent.json");

			ObjectNode node = new ObjectMapper().readValue(inputStream, ObjectNode.class);
			byte[] bytes = mapper.writeValueAsBytes(node.get("data"));
			System.out.println("==========>" + node.get("data"));

			try {
				List<Parent> parentList = mapper.readValue(bytes,typeReference);
				parentService.saveAll(parentList);
				System.out.println("Parents Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Parents: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner runner2(ChildService childService){
		return args -> {
			// read JSON Array and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Child>> typeReference = new TypeReference<List<Child>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Child.json");

			ObjectNode node = new ObjectMapper().readValue(inputStream, ObjectNode.class);
			byte[] bytes = mapper.writeValueAsBytes(node.get("data"));
			System.out.println("==========>" + node.get("data"));

			try {
				List<Child> children = mapper.readValue(bytes,typeReference);
				childService.saveAll(children);
				System.out.println("children Saved!");
			} catch (IOException e){
				System.out.println("Unable to save children: " + e.getMessage());
			}
		};
	}



}
