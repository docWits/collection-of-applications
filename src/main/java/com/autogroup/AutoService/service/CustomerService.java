package com.autogroup.AutoService.service;

import com.autogroup.AutoService.model.Auto;
import com.autogroup.AutoService.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer addCustomer(Customer customer);
    Customer getById(Long id);
    void deleteCustomer(Long id);
}
