package com.sbthymeleaf.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbthymeleaf.model.Employee;
import com.sbthymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.io.IOException;

@Controller
public class EmployeeController {
//
//    @Autowired
//    EmployeeService employeeService;

    @GetMapping("/employeeForm")
    public String showEmployeeForm(Model model) {
        // Populate model with necessary data if needed
        return "employee-form";
    }

    @PostMapping("/saveEmployeeData")
    public String saveEmployeeData(@RequestBody Employee employee) {
        // Call the service method to save employee data
       // boolean success = employeeService.saveEmployeeData(employee);

        try {
            ObjectMapper mapper = new ObjectMapper();

            String customerJson = mapper.writeValueAsString(employee);

            File file = new File("employee_data.json");
            mapper.writeValue(file, customerJson);
            //model.addAttribute("message", "Customer data saved successfully!");
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to save customer data!";
        }
//
//        if (success) {
//            return new ResponseEntity<>("Employee data saved successfully!", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Failed to save employee data", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }
}
