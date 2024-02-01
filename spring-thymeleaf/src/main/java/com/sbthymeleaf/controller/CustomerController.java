package com.sbthymeleaf.controller;

import com.sbthymeleaf.model.Customer;
import com.sbthymeleaf.model.KycDetails;
import com.sbthymeleaf.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
@Slf4j
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public String customer(Model model) {

        // Create a sample Customer object for demonstration
        Customer customer = new Customer();
        customer.setCustomerId("C123");
        customer.setProfileId(Arrays.asList("profile1", "profile2"));
        customer.setSearchScope(0.5f);
        customer.setDateOfBirth("1990-01-01");
        customer.setSourceName("Example Source");
        customer.setSourceId("12345");

        // Create a sample KycDetails object
        KycDetails kycDetails = new KycDetails();
        kycDetails.setStatus("Verified");
        kycDetails.setVerificationLevel("High");

        // Set the KycDetails object to the Customer
        customer.setKycDetails(kycDetails);

        // Add the Customer object to the model
        model.addAttribute("customer", customer);

        return "customer"; // return the name of the HTML template
    }
}
