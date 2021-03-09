package com.example.SpringWeb.controller;

import com.example.SpringWeb.domain.Customer;
import com.example.SpringWeb.repository.CustomerRepository;
import com.example.SpringWeb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    private List<Customer> getAllCustomer()
    {
        return customerService.getAllCustomers();
    }
    //creating a get mapping that retrieves the detail of a specific customer
    @GetMapping("/getcustomer/{id}")
    private Customer getCustomer(@PathVariable("id") Long id)
    {
        return customerService.getCustomerById(id);
    }
    //creating a delete mapping that deletes a specific customer
    @GetMapping("/deletecustomer/{id}")
    private void deleteCustomer(@PathVariable("id") Long id)
    {
        customerService.delete(id);
    }
    //creating post mapping that post the customer detail in the database
    //http://localhost:8080/add/somename/email/7896678/30
    @GetMapping("/add/{name}/{email}/{phone}/{age}")
    private void saveCustomer(@PathVariable("name") String name,
                              @PathVariable("email") String email,
                              @PathVariable("phone") String phone,
                              @PathVariable("age") int age)
    {
        Customer c = new Customer();
        System.out.println(name);
        c.setName(name);
        //c.setId(id);
        c.setEmail(email);
        c.setPhone(phone);
        c.setAge(age);

        customerService.save(c);
    }
    @GetMapping("/add")
    public ModelAndView saveCustomer(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("add");
        return mv;
    }
    /*
    @RequestMapping("/fetch")
    public ModelAndView fetch(@RequestParam("id") Long id){
        ModelAndView mv=new ModelAndView();
        Customer c=customerService.findById(id);
        mv.addObject("obj", c);
        System.out.println(c.getName()+c.getEmail());
        mv.setViewName("fetch");
        return mv;

    }
    @GetMapping("/list")
    public Iterable<Customer> list(){
        return customerService.list();
    }*/
}
