package com.sbthymeleaf.model;

import lombok.*;
import java.util.Map;
import javax.xml.bind.annotation.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phone;
    private String address;
    private String department;
    private String position;
    @XmlElementWrapper(name = "skills")
    @XmlElement(name = "skill")
    private String[] skills;
    @XmlElementWrapper(name = "metadata")
    @XmlElement(name = "entry")
    private Map<String, String> metadata;

}
