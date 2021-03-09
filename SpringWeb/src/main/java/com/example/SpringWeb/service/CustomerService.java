package com.example.SpringWeb.service;

import com.example.SpringWeb.domain.Customer;
import com.example.SpringWeb.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> list(){
        return customerRepository.findAll();
    }
    public Customer save(Customer customer){
        return customerRepository.save(customer);

    }
    public Iterable<Customer> save(List<Customer> customers){
        return customerRepository.saveAll(customers);

    }

    public Customer getCustomerById(Long id){
       return customerRepository.findById(id).get();

    }
    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customer -> customers.add(customer));
        return customers;
    }
    public void delete(Long id)
    {
        customerRepository.deleteById(id);
    }
}
