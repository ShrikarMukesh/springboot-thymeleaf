package com.sbthymeleaf.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class XsdElement {

    private String name;
    private String type;
    private boolean required;

    public XsdElement(String name, String type, boolean required) {
        this.name = name;
        this.type = type;
        this.required = required;
    }
}
