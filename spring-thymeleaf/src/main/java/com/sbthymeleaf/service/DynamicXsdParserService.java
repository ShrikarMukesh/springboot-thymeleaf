package com.sbthymeleaf.service;

import com.sbthymeleaf.model.Employee;
import com.sbthymeleaf.model.XsdElement;
import com.sbthymeleaf.model.XsdStructureInfo;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class DynamicXsdParserService {

    private final ResourceLoader resourceLoader;

    public DynamicXsdParserService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public XsdStructureInfo parseXsd(String xsdFileName) {
        try {
            Resource resource = resourceLoader.getResource("classpath:" + xsdFileName);
            InputStream inputStream = resource.getInputStream();

            JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Employee employee = (Employee) jaxbUnmarshaller.unmarshal(inputStream);

            // Create XsdStructureInfo and populate dynamically
            XsdStructureInfo structureInfo = new XsdStructureInfo();
            List<XsdElement> elements = new ArrayList<>();

            // Use reflection to dynamically inspect the fields of the Employee class
            Class<?> employeeClass = employee.getClass();
            Field[] fields = employeeClass.getDeclaredFields();

            for (Field field : fields) {
                // Extract field name and type dynamically
                String fieldName = field.getName();
                String fieldType = field.getType().getSimpleName();

                // Add extracted field information to XsdElement list
                elements.add(new XsdElement(fieldName, fieldType, true)); // Assuming all fields are required
            }

            structureInfo.setElements(elements);
            return structureInfo;

        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
            return null;
        }
    }
}
