package com.example.shop_store.controllers;

import com.example.shop_store.domain.Pakets;
import com.example.shop_store.repos.PaketsRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/rest", produces = "application/json")
//@CrossOrigin("http://localhost:8080")
public class PaketRestController {
    private PaketsRepo paketsRepo;
    public PaketRestController(PaketsRepo paketsRepo){
        this.paketsRepo = paketsRepo;
    }

    @GetMapping("/all")
    public Iterable<Pakets> indexGET(){
        return paketsRepo.findAll();
    }


    @PostMapping("/all")
    public Iterable<Pakets> index(){
        return paketsRepo.findAll();
    }

    @PostMapping("/add_new")
    public Pakets test(@RequestBody Pakets pakets){
        paketsRepo.save(pakets);
        return pakets;
    }

    @PostMapping("/findByName")
    public Iterable<Pakets> findByName(@RequestBody String body) throws JsonProcessingException {
        System.out.println(body);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.readValue(body, Map.class);

        String name = map.get("name");
        System.out.println(name);

        return paketsRepo.findAllByName(name);
    }

    @PostMapping("/findByArtikul")
    public Iterable<Pakets> findByArtikul(@RequestBody String body) throws JsonProcessingException {
        System.out.println(body);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.readValue(body, Map.class);
        String artikul = map.get("artikul");

        System.out.println(artikul);

        return paketsRepo.findAllByArtikul(artikul);
    }

    @PostMapping("/findByPrice")
    public Iterable<Pakets> findByPrice(@RequestBody String body) throws JsonProcessingException {
        System.out.println(body);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.readValue(body, Map.class);
        String price = map.get("price");
        Double priceDouble = Double.parseDouble(price);

        System.out.println(price);

        return paketsRepo.findAllByPrice(priceDouble);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestBody String body) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.readValue(body, Map.class);
        String id = map.get("id");
        Long idLong = Long.parseLong(id);

        paketsRepo.deleteById(idLong);

        return true;
    }
}

