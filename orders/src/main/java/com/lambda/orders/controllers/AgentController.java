package com.lambda.orders.controllers;

import com.lambda.orders.repos.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agent")
public class AgentController {
	@Autowired
	private AgentsRepository agentRepo;

	//DELETE localhost:2019/agent/{id}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAgent(@PathVariable long id){
		agentRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
