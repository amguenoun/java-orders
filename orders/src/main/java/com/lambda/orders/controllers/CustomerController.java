package com.lambda.orders.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	//wire service here

	//GET localhost:2019/customer/order -Returns all customers with their orders

	//POST localhost:2019/customer/new - Adds a new customer including any new orders

	//PUT localhost:2019/customer/update/{custcode} - Updates the customer based off of custcode. Does not have to do anything with Orders

	//DELETE localhost:2019/customer/delete/{custcode} - Deletes the customer based off of custcode
}
