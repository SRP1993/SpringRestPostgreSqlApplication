package com.javasampleapproach.springrest.postgresql.service.ServiceImpl;

import com.javasampleapproach.springrest.postgresql.model.Customer;
import com.javasampleapproach.springrest.postgresql.repo.CustomerRepository;
import com.javasampleapproach.springrest.postgresql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public List<Customer> getAllCustomers() {
        System.out.println("Get all Customers...");

        List<Customer> customers = new ArrayList<>();
        repository.findAll().forEach(customers::add);
        System.out.println(customers.size());

        return customers;
    }

    @Override
    public Customer postCustomer(Customer customer){
        System.out.println("putting data------------------------");
        Customer _customer = repository.save(new Customer(customer.getName(), customer.getAge()));
        return _customer;
    }
    @Override
    public String deleteCustomer(long id) {
        System.out.println("Delete Customer with ID = " + id + "...");

        repository.deleteById(id);

        return "deleted";
    }

    @Override
    public String deleteAllCustomers() {
        System.out.println("Delete All Customers...");

        repository.deleteAll();

        return "deleteAll";
    }

    @Override
    public List<Customer> findByAge(int age) {
        System.out.println("checking... in age.......");
        List<Customer> customers = repository.findByAge(Integer.valueOf(age));
        return customers;
    }

   /* @Override*/
   /* public Customer updateCustomer() {
        System.out.println("Update Customer with ID = " + id + "...");

        Optional<Customer> customerData = repository.findById(id);

       *//* if (customerData.isPresent()) {
            Customer _customer = customerData.get();
            _customer.setName(customer.getName());
            _customer.setAge(customer.getAge());
            _customer.setActive(customer.isActive());
            return repository.save(_customer);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*//*
        return customerData;
    }*/




}
