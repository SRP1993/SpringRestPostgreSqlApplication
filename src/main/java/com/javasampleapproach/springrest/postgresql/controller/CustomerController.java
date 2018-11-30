package com.javasampleapproach.springrest.postgresql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.javasampleapproach.springrest.postgresql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javasampleapproach.springrest.postgresql.model.Customer;
import com.javasampleapproach.springrest.postgresql.repo.CustomerRepository;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://ec2-13-233-106-156.ap-south-1.compute.amazonaws.com:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	/*@Autowired
	RestTemplate restTemplate;*/


	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		System.out.println("Get all Customers...");

		List<Customer> customers = new ArrayList<>();
		//repository.findAll().forEach(customers::add);
        customers= customerService.getAllCustomers();
		System.out.println(customers.size());
		return customers;
	}

	@PostMapping(value = "/customers/create")
	public Customer postCustomer(@RequestBody Customer customer) {
        System.out.println("putting data------------------------");
		Customer _customer = customerService.postCustomer(new Customer(customer.getName(), customer.getAge()));
		return _customer;
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
		System.out.println("Delete Customer with ID = " + id + "...");

        customerService.deleteCustomer(id);

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/customers/delete")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All Customers...");

        customerService.deleteAllCustomers();

		return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
	}

	@GetMapping(value = "customers/age/{age}")
	public List<Customer> findByAge(@PathVariable String age) {
		System.out.println("checking... in age.......");
		List<Customer> customers = customerService.findByAge(Integer.valueOf(age));
		return customers;
	}

	/*@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		System.out.println("Update Customer with ID = " + id + "...");

		Optional<Customer> customerData = repository.findById(id);

		if (customerData.isPresent()) {
			Customer _customer = customerData.get();
			_customer.setName(customer.getName());
			_customer.setAge(customer.getAge());
			_customer.setActive(customer.isActive());
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}*/
	/*@GetMapping(value = "customers/age/{age}")
	public List<Customer> findByAge(@PathVariable String age) {
		System.out.println("checking... in age.......");
		List<Customer> customers = customerService.findByAge(Integer.valueOf(age));
		return customers;
	}*/



}
