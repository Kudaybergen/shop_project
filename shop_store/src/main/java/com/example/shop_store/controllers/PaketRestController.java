package com.example.shop_store.controllers;

import com.example.shop_store.domain.Pakets;
import com.example.shop_store.repos.PaketsRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest", produces = "application/json")
//@CrossOrigin("http://localhost:8080")
public class PaketRestController {
    private PaketsRepo paketsRepo;
    public PaketRestController(PaketsRepo paketsRepo){
        this.paketsRepo = paketsRepo;
    }


    @GetMapping("/")
    public Iterable<Pakets> index(){
        return paketsRepo.findAll();
    }

    @GetMapping("/test")
    public Iterable<Pakets> test(){
        return paketsRepo.findAll();
    }
}
