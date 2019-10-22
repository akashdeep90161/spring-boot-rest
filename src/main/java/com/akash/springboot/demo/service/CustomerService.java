package com.akash.springboot.demo.service;

import com.akash.springboot.demo.dao.CustomerDao;
import com.akash.springboot.demo.exception.CustomerNotFoundException;
import com.akash.springboot.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;
    List<Customer> customerList=new CopyOnWriteArrayList<>();  //Normal list is not good for concurrent operation.
                                                                // So we will use CopyOnWriteArrayList
    private int customerIdCount=1;
    public Customer addCustomer(Customer customer)
    {
        /*customer.setId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;*/
       return customerDao.save(customer);

    }

    public List<Customer> getCustomerList()
    {
        //return customerList;
        return customerDao.findAll();
    }
    public Customer getCustomer(int customerId)
    {
        Optional<Customer> customer=customerDao.findById(customerId);
        if (!customer.isPresent())
        {
            throw new CustomerNotFoundException("Customer Record with Id:"+customerId+" is not present....");
        }
        return customerDao.findById(customerId).get();
        /*return customerList
                .stream()
                .filter(c-> c.getId()==customerId)
                .findFirst()
                .get();*/
    }
    public Customer updateCustomer(int id, Customer customer)
    {
        customer.setId(id);
        return customerDao.save(customer);
       /* customerList
                .stream()
                .forEach(c->{
                    if(c.getId()==id){
                        c.setFirstName(customer.getFirstName());
                        c.setLastName(customer.getLastName());
                        c.setEmail(customer.getEmail());
                    }
                });
        return customerList
                .stream()
                .filter(c-> c.getId()==id)
                .findFirst()
                .get();*/
    }

    public void deleteCustomer(int id)
    {
        customerDao.deleteById(id);
       /* customerList.stream()
                .forEach(c->{
                    if(c.getId()==id)
                    {
                        customerList.remove(c);
                    }
                    else
                    {

                    }
                });*/
    }
}
