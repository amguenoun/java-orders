package com.lambda.orders.services;

import com.lambda.orders.models.Customer;
import com.lambda.orders.models.Order;
import com.lambda.orders.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomersRepository custRepo;

	@Override
	public List<Customer> findAll() {
		List<Customer> rtnList = new ArrayList<>();
		custRepo.findAll().iterator().forEachRemaining(rtnList::add);
		return rtnList;
	}

	@Override
	public Customer findById(long id) {
		return custRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found " + id));
	}


	@Transactional
	@Override
	public Customer save(Customer customer) {
		Customer newCustomer = new Customer();

		newCustomer.setCustname(customer.getCustname());
		newCustomer.setCustcity(customer.getCustcity());
		newCustomer.setWorkingarea(customer.getWorkingarea());
		newCustomer.setCustcountry(customer.getCustcountry());
		newCustomer.setGrade(customer.getGrade());
		newCustomer.setOpeningamt(customer.getOpeningamt());
		newCustomer.setReceiveamt(customer.getReceiveamt());
		newCustomer.setPaymentamt(customer.getPaymentamt());
		newCustomer.setOutstandingamt(customer.getOutstandingamt());
		newCustomer.setPhone(customer.getPhone());
		newCustomer.setAgent(customer.getAgent());

		for(Order o : customer.getOrders()){
			newCustomer.getOrders().add(new Order(o.getOrdamount(), o.getAdvanceamount(), o.getCustomer(), o.getOrddescription()));
		}

		return custRepo.save(newCustomer);

	}

	@Override
	public Customer update(Customer customer, long id) {
		return custRepo.save(customer);
	}

	@Override
	public void delete(long id) {
		custRepo.deleteById(id);
	}
}
