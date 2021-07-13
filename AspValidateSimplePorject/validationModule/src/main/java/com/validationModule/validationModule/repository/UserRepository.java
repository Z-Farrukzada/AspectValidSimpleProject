package com.validationModule.validationModule.repository;

import com.validationModule.validationModule.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Repository
public class UserRepository {

    private static List<User> users = new ArrayList<>();

    public ResponseEntity save(User user){
        boolean isCreated = users.add(user);
        if(isCreated){
           return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    public List<User> findAll() {
        return users;
    }
}
