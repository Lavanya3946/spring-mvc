package com.xworkz.userapp.controller;

import com.xworkz.userapp.dto.UserDto;
import com.xworkz.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;

    public UserController() {
        System.out.println("userController object is created");
    }

    @RequestMapping("/addUser")
    public String addUser(UserDto userDto) {
        userService.validateAndSave(userDto);
        return "response.jsp";
    }
}
