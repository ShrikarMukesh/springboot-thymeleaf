package com.sbthymeleaf.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbthymeleaf.model.Employee;
import com.sbthymeleaf.model.XsdStructureInfo;
import com.sbthymeleaf.service.DynamicXsdParserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class EmployeeController {

    private final DynamicXsdParserService xsdParserService;

    public EmployeeController(DynamicXsdParserService xsdParserService) {
        this.xsdParserService = xsdParserService;
    }

    @GetMapping("/showEmployeeForAdd")
    public String showFormForAdd(Model model) {
        // Parse the XSD file and extract structure information
        XsdStructureInfo structureInfo = xsdParserService.parseXsd("Employee.xsd");

        // Pass the structure information to the HTML page
        model.addAttribute("structureInfo", structureInfo);

        // Return the name of the Thymeleaf template
        return "employee-form";
    }

//    @GetMapping("/employeeForm")
//    public String showEmployeeForm(Model model) {
//        return "employee-form";
//    }

    @PostMapping("/saveEmployeeData")
    public String saveEmployeeData(@RequestBody Employee employee) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String customerJson = mapper.writeValueAsString(employee);
            File file = new File("employee_data.json");
            mapper.writeValue(file, customerJson);
            return "success";
        } catch (IOException e) {
            log.error("Failed to get the data");
            return "Failed to save customer data!";
        }

    }


}
