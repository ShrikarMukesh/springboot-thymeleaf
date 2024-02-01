package com.sbthymeleaf.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class KycDetails {

    private String status;
    private String verificationLevel;

}
