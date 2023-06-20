package com.example.shop_store.controllers;


import com.example.shop_store.repos.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
