package com.sbthymeleaf.model;

import lombok.*;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Customer {

    private String customerId;
    private List<String> profileId;
    private float searchScope;
    private String dateOfBirth;
    private String sourceName;
    private String sourceId;
    private KycDetails kycDetails;

}

