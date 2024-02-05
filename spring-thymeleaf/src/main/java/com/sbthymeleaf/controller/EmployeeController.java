package com.sbthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class EmployeeController {

    @GetMapping("/employeeForm")
    public String showEmployeeForm(Model model) {
        // Populate model with necessary data if needed
        return "employee-form";
    }

    // Add other controller methods as needed
}
