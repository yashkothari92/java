package com.microservices.practice.resource;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.practice.model.Greeting;

@RestController
public class GreetingResource {

	AtomicInteger id = new AtomicInteger(1);
	String str = "Hello, %s!";
	
	/**
	@RequestMapping("/greeting")
	public Greeting greet() {
		String name = "User";
		return new Greeting(id.incrementAndGet(), "Hello!");
	}*/

	// http:localhost:8080/greeting?name=Programmer
	@RequestMapping("/greeting")
	public Greeting greetPerson(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(id.incrementAndGet(), String.format(str, name));
	}
}
