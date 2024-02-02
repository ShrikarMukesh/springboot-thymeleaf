package com.sbthymeleaf.service;

import com.sbthymeleaf.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

    public void saveCustomer(Customer customer) {
        log.info("customer"  + customer);
    }

    public Customer findByCustomerId(String customerId) {
        return new Customer();
    }

    public void delete(Customer theCustomer) {
    }
}
