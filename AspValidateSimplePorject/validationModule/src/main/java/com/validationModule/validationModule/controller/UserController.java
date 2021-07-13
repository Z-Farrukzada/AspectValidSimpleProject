package com.validationModule.validationModule.controller;


import com.validationModule.validationModule.annotation.CheckValidate;
import com.validationModule.validationModule.model.User;
import com.validationModule.validationModule.service.UserService;
import com.validationModule.validationModule.service.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/create")
    @CheckValidate
    public ResponseEntity save(@Valid @RequestBody UserDto userDto, BindingResult bindingResult){
         return userService.save(userDto);
    }

    @GetMapping("/all")
    public List<User> findAll(){
        return userService.findAll();
    }

}
