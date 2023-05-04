package com.example.shop_store.controllers;

import com.example.shop_store.domain.Goods;
import com.example.shop_store.repos.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private GoodsRepo goodsRepo;

    @GetMapping("/add_good")
    public String addGood(){
        return "addGood";
    }
    @PostMapping("/add_good")
    public String addGoodP(@RequestParam(value = "goodName", required = false) String goodName,
                           @RequestParam(value = "goodDesc", required = false) String goodDesc,
                           @RequestParam(value = "goodPrice", required = false) Integer price){
        System.out.println(goodDesc + goodName + price);
        Goods goods = new Goods(goodName, goodDesc, price);
        goodsRepo.save(goods);
        return "redirect:/";
    }

    @GetMapping("/catalog")
    public String catalog(Model model){
        Iterable<Goods> goods = goodsRepo.findAll();
        System.out.println(goods);
        model.addAttribute("goods", goods);
        return "catalog";
    }
}
