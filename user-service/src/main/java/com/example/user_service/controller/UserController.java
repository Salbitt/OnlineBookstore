package com.example.user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/users/")
public class UserController {

    @GetMapping
    public String sendMessage()
    {
        return "Hello from user service";
    }

    @GetMapping("admin/welcome")
    public String sendAdminMessage()
    {
        return "Hello to admin from user service";
    }
}
