package com.nwmsu.topicoftheDay2A;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class TopicoftheDay2AApplication implements CommandLineRunner {
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(TopicoftheDay2AApplication.class, args);
	}
	 @Override
	    public void run(String... args) throws Exception {
	        String sql = "INSERT INTO public.topics(\n"
	        		+ "	\"Weekdays\", \"Nameofthetopic\")\n"
	        		+ "	VALUES ('monday', 'Application frameworks')";
	         
	        int rows = jdbcTemplate.update(sql);
	        if (rows > 0 ) {
	            System.out.println("A new row has been inserted.");
	        }
	    }

}
