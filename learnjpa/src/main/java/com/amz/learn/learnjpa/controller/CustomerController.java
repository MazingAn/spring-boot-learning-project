package com.amz.learn.learnjpa.controller;


import com.amz.learn.learnjpa.beans.Customer;
import com.amz.learn.learnjpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewCustomer(@RequestParam String firstName,
                                               @RequestParam String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customerRepository.save(customer);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
