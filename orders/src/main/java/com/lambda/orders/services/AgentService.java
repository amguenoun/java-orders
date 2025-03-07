package com.lambda.orders.services;

import com.lambda.orders.models.Agent;

import java.util.List;

public interface AgentService {
	List<Agent> findAll();

	Agent findById(long id);

	Agent save(Agent agent);

	Agent update(Agent agent, long id);

	void delete(long id);
}
