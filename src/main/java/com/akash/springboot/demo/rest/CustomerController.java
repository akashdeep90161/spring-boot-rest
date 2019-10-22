package com.akash.springboot.demo.rest;

import com.akash.springboot.demo.model.Customer;
import com.akash.springboot.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer)
    {
        return customerService.addCustomer(customer);
    }


    @GetMapping ("/getCustomerList")
    public List<Customer> getCustomers()
    {
      return customerService.getCustomerList();
    }

    @GetMapping("/getCustomerById"+"/{id}")
    public Customer getCustomer(@PathVariable("id") int id)
    {
        return customerService.getCustomer(id);
    }
    @PutMapping("/updateCustomer"+"/{id}")
    public Customer updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer)
    {
        return customerService.updateCustomer(id,customer);
    }
    @DeleteMapping("/deleteCustomer"+"/{id}")
    public void deleteCustomer(@PathVariable("id") int id)
    {
         customerService.deleteCustomer(id);
    }
}