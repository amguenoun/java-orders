package com.lambda.orders.controllers;

import com.lambda.orders.models.Customer;
import com.lambda.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	//wire service here
	@Autowired
	private CustomerService customerService;

	//GET localhost:2019/customer/order -Returns all customers with their orders
	@GetMapping(value="/order", produces = {"application/json"})
	public ResponseEntity<?> getAllCustomers(){
		return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
	}

	//POST localhost:2019/customer/new - Adds a new customer including any new orders
	@PostMapping(value = "/new", consumes = {"application/json"})
	public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer customer){
		customerService.save(customer);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//PUT localhost:2019/customer/update/{custcode} - Updates the customer based off of custcode. Does not have to do anything with Orders
	@PutMapping(value = "/update/{id}", consumes = {"application/json"})
	public ResponseEntity<?> updateCustomer(@PathVariable long id, @RequestBody Customer customer){
		customerService.update(customer, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	//DELETE localhost:2019/customer/delete/{custcode} - Deletes the customer based off of custcode
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable long id){
		customerService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
