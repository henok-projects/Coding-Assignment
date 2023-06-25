package com.sample.demo;

import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.demo.domains.Child;
import com.sample.demo.domains.Parent;
import com.sample.demo.services.ChildService;
import com.sample.demo.services.ParentService;
import org.json.simple.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileReader;
import java.util.List;

import static org.json.simple.JSONValue.parse;

@SpringBootApplication
public class CodingAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingAssignmentApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(ParentService parentService,ChildService childService){
		return args -> {

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

			try {

				String parentData = ((JSONObject)parse(new FileReader("src/main/resources/json/Parent.json"))).get("data").toString();
				String childData = ((JSONObject)parse(new FileReader("src/main/resources/json/Child.json"))).get("data").toString();
				List<Parent> parents = mapper.readValue(parentData, new TypeReference<>(){});
				List<Child> children = mapper.readValue(childData, new TypeReference<>(){});

				parentService.saveAll(parents);
				childService.saveAll(children);

			} catch(Exception e) {
				e.printStackTrace();
			}

		};

	}


}
