package com.example.shop_store.controllers;

import com.example.shop_store.domain.Goods;
import com.example.shop_store.repos.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private GoodsRepo goodsRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/add_good")
    public String addGood(){
        return "addGood";
    }
    @PostMapping("/add_good")
    public String addGoodP(@RequestParam(value = "goodName", required = false) String goodName,
                           @RequestParam(value = "goodDesc", required = false) String goodDesc,
                           @RequestParam(value = "goodPrice", required = false) Integer price,
                           @RequestParam(value = "file", required = false) MultipartFile multipartFile) throws IOException {
        Goods goods = new Goods(goodName, goodDesc, price);
        if (multipartFile != null){
            File someFile = new File(uploadPath);

            if (!someFile.exists()){
                someFile.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + multipartFile.getOriginalFilename();

            multipartFile.transferTo(new File(uploadPath + "/" + resultFileName));

            goods.setFilename(resultFileName);
        }
        goodsRepo.save(goods);
        return "redirect:/";
    }

    @GetMapping("/catalog")
    public String catalog(Model model){
        Iterable<Goods> goods = goodsRepo.findAll();
        model.addAttribute("goods", goods);
        return "catalog";
    }

    @GetMapping("/catalog/{id}")
    public String catalogView(@PathVariable String id, Model model){
        Long long_id = Long.parseLong(id);
        Goods good = goodsRepo.findById(long_id).get();
        model.addAttribute("good", good);
        return "catalogView";
    }

    @GetMapping("/test")
    public String test(Model model){
        String png_url = "2b2c5a65-d74e-4965-b5c7-92beee371933.Screenshot from 2023-04-19 23-36-08.png";
        model.addAttribute("png", png_url);
        return "test";
    }
}
