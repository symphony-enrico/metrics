package com.symphony.metrics.micrometer.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.symphony.metrics.micrometer.dto.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s from MicrometerCustomApplication!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(),
							String.format(template, name));
	}
}
