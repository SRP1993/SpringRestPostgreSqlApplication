package com.javasampleapproach.springrest.postgresql;

import com.javasampleapproach.springrest.postgresql.model.Customer;
import com.javasampleapproach.springrest.postgresql.repo.CustomerRepository;
import com.javasampleapproach.springrest.postgresql.service.CustomerService;
import com.javasampleapproach.springrest.postgresql.service.ServiceImpl.CustomerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SpringRestPostgreSqlApplicationTests {


	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	@Mock
	CustomerRepository customerRepository;

	@Test
	public void testGetAllCustomers() {

		/*List<Customer> list = new ArrayList<Customer>();
		when(customerServiceImpl.getAllCustomers()).thenReturn(list);
		customerService.getAllCustomers();

		assertEquals(6, list.size());*/


		List<Customer> list = new ArrayList<Customer>();
		Customer customer=new Customer();
		list.add(customer);
		when(customerRepository.findAll()).thenReturn(list);
		List<Customer> lists=customerServiceImpl.getAllCustomers();
		System.out.println(lists.size());
		assertEquals(1, list.size());

	}

}
