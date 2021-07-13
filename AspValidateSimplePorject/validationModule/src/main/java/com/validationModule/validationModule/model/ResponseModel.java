package com.validationModule.validationModule.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {

    private  int httpStatus;
    private  String data;
    private  List<String> list;

}
