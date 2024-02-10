package com.sbthymeleaf.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbthymeleaf.model.Customer;
import com.sbthymeleaf.model.KycDetails;
import com.sbthymeleaf.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Controller
@Slf4j
public class CustomerController {

    CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

//    @PostMapping("/save")
//    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
//        log.info("theCustomer" + theCustomer);
//        customerService.saveCustomer(theCustomer);
//        return "redirect:/customers/list";
//    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        log.info("Inside saveCustomer");
        log.info("customer from ModelAttribute  " + customer);
        try {
            ObjectMapper mapper = new ObjectMapper();

            String customerJson = mapper.writeValueAsString(customer);

            File file = new File("customer_data.json");
            mapper.writeValue(file, customerJson);
            model.addAttribute("message", "Customer data saved successfully!");
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to save customer data!";
        }
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") String customerId, Model theModel) {
        Customer theCustomer = customerService.findByCustomerId(customerId);
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @GetMapping("/showFormForDelete")
    public String showFormForDelete(@RequestParam("customerId") String customerId) {
        Customer theCustomer = customerService.findByCustomerId(customerId);
        customerService.delete(theCustomer);
        return "redirect:/customers/list";
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
