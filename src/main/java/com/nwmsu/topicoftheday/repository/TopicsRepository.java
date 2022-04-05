package com.nwmsu.topicoftheday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nwmsu.topicoftheday.model.*;


	@Repository
	public interface TopicsRepository extends JpaRepository<Topics, Long>{

	}
