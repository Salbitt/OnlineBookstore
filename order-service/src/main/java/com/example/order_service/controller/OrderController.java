package com.example.order_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/orders/")
public class OrderController {

    @GetMapping
    public String sendMessage()
    {
        return "Hello from order service";
    }


}
