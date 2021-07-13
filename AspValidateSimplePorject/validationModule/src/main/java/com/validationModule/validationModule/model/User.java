package com.validationModule.validationModule.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String name;
    private String userName;
    private String fatherName;
    private int age;
    private int mobileNumber;
    private String email;
    private String position;
    private String about;

}