package com.validationModule.validationModule.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto  {

    @NotBlank(message = "name cannot be empty")
    private String name;
    @NotBlank(message = "username cannot be empty")
    private String userName;
    @NotBlank(message = "fathername cannot be empty")
    private String fatherName;
    @NotNull(message = "age cannot be empty")
    private int age;
    @NotNull
    //@Pattern(regexp = "^\\+?\\d{3} ?\\d{2} ?\\d{3} ?\\d{2} ?\\d{2}$",message = "error_validate_mobile_number")
    private int mobileNumber;
    @Pattern(regexp = "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+" +
            "(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})", message = "error_validate_email")
    private String email;
    @NotBlank(message = "position cannot be empty")
    private String position;
    private String about;

}
