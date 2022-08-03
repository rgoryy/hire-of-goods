package ru.cft.hireofgoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.cft.hireofgoods.repository.model.UserEntity;
import ru.cft.hireofgoods.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/get/users")
    public List<UserEntity> getAll() {
        return userService.getAllUser();
    }

    @GetMapping("/get/users/email")
    public List<String> getAllUsersEmail(){
        return userService.getAllUsersEmail();
    }

    @PostMapping("create-user")
    public void createUser(@RequestBody UserEntity userEntity){
        this.userService.createUser(userEntity.getFirstName(),
                                    userEntity.getLastName(),
                                    userEntity.getMiddleName(),
                                    userEntity.getLogin(),
                                    userEntity.getEmail());
    }

}