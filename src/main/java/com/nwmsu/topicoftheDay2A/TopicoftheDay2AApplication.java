package com.nwmsu.topicoftheDay2A;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Controller
@SpringBootApplication
public class TopicoftheDay2AApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopicoftheDay2AApplication.class, args);
	}
	@RequestMapping("/")
	String index() {
		return "index";
	}

}
