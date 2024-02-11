package com.sbthymeleaf.service;

import com.sbthymeleaf.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class EmployeeFormGenerator {

    @Value("${xsd.path:classpath:employee.xsd}")
    private String xsdPath;

    private JAXBContext context;

    @PostConstruct
    public void init() throws JAXBException, javax.xml.bind.JAXBException {
        context = JAXBContext.newInstance(Employee.class);
    }

    public String generateForm() throws JAXBException, SAXException {
        File xsdFile = new File(xsdPath);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Employee employee = (Employee) unmarshaller.unmarshal(xsdFile);

        // Build HTML structure based on employee object and XSD info
        // (you can use similar logic as the previous example)
        //return html;
        return null;
    }
}
