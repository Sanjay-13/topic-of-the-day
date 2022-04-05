package com.nwmsu.topicoftheday.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nwmsu.topicoftheday.model.Topics;
import com.nwmsu.topicoftheday.repository.TopicsRepository;
import com.nwmsu.topicoftheday.exception.ResourceNotFoundException;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class TopicsController {

	@Autowired
	private TopicsRepository topicsRepository;
	
	@GetMapping("/topics")
	public List<Topics> getAllTopics(){
		return topicsRepository.findAll();
	}
	
	@PostMapping("/topics")
	public Topics createEmployee(@RequestBody Topics topics) {
		return topicsRepository.save(topics);
	}
	
	@GetMapping("/topics/{id}")
	public ResponseEntity<Topics> getEmployeeById(@PathVariable Long id) {
		Topics topics = topicsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Topic does not exist with id :" + id));
		return ResponseEntity.ok(topics);
	}
	@PutMapping("/topics/{id}")
	public ResponseEntity<Topics> updateTopics(@PathVariable Long id, @RequestBody Topics topicDetails){
		Topics topics = topicsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Topic not exist with id :" + id));
		
		topics.setTopicName(topicDetails.getTopicName());
		topics.setDescription(topicDetails.getDescription());
		
		
		Topics updateTopics = topicsRepository.save(topics);
		return ResponseEntity.ok(updateTopics);
	}
	
	// delete employee rest api
	@DeleteMapping("/topics/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTopic(@PathVariable Long id){
		Topics topics = topicsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Topic not exist with id :" + id));
		
		topicsRepository.delete(topics);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
