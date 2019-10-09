package com.lambda.orders.services;

import com.lambda.orders.models.Agent;
import com.lambda.orders.models.Customer;
import com.lambda.orders.repos.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("agentService")
public class AgentServiceImpl implements AgentService {
	@Autowired
	private AgentsRepository agentRepo;

	@Override
	public List<Agent> findAll() {
		List<Agent> rtnList = new ArrayList<>();
		agentRepo.findAll().iterator().forEachRemaining(rtnList::add);
		return rtnList;
	}

	@Override
	public Agent findById(long id) {
		return agentRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found " + id));
	}

	@Override
	public Agent save(Agent agent) {
		Agent newAgent = new Agent();
		newAgent.setAgentname(agent.getAgentname());
		newAgent.setWorkingarea(agent.getWorkingarea());
		newAgent.setCommission(agent.getCommission());
		newAgent.setPhone(agent.getPhone());
		newAgent.setCountry(agent.getCountry());

		for(Customer c : agent.getCustomers()){
			agent.getCustomers().add(new Customer(c.getCustname(), c.getCustcity(),c.getWorkingarea(),
					c.getCustcountry(), c.getGrade(), c.getOpeningamt(),c.getReceiveamt(),c.getPaymentamt(),
					c.getOutstandingamt(), c.getPhone(), c.getAgent()));
		}

		return agentRepo.save(newAgent);
	}

	@Override
	public Agent update(Agent agent, long id) {
		return agentRepo.save(agent);
	}

	@Override
	public void delete(long id) {
		agentRepo.deleteById(id);
	}
}
