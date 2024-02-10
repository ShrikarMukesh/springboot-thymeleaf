package com.sbthymeleaf.service;

import com.sbthymeleaf.model.Employee;

public class EmployeeService {
    public boolean saveEmployeeData(Employee employee) {
        return true;
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//
//            String customerJson = mapper.writeValueAsString(employee);
//
//            File file = new File("customer_data.json");
//            mapper.writeValue(file, customerJson);
//            model.addAttribute("message", "Customer data saved successfully!");
//            return "success";
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "Failed to save customer data!";
//        }
    }
}
