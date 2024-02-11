package com.sbthymeleaf.controller;

import com.sbthymeleaf.service.EmployeeFormGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeControllerV2 {

    @Autowired
    private EmployeeFormGenerator employeeFormGenerator;

    @GetMapping("/form")
    public ModelAndView getEmployeeForm() throws JAXBException, SAXException {
        Map<String, Object> model = new HashMap<>();
        model.put("employeeForm", employeeFormGenerator.generateForm());
        return new ModelAndView("employee-form-v2", model);
    }
}
