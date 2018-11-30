package com.javasampleapproach.springrest.postgresql.service;

import com.javasampleapproach.springrest.postgresql.model.Customer;
import com.javasampleapproach.springrest.postgresql.service.ServiceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService {


    public List<Customer> getAllCustomers();
    public Customer postCustomer(Customer customer);
    public String deleteCustomer(long id);
    public String deleteAllCustomers();
    public List<Customer> findByAge(int age);
    /*public Customer updateCustomer();*/


}
