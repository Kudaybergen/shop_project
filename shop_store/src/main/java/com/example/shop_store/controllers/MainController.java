package com.example.shop_store.controllers;

import com.example.shop_store.domain.Category;
import com.example.shop_store.domain.Goods;
import com.example.shop_store.repos.CategoryRepo;
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
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private GoodsRepo goodsRepo;

    @Autowired
    private CategoryRepo categoryRepo;

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
                           @RequestParam(value = "category", required = false) Integer category,
                           @RequestParam(value = "file", required = false) MultipartFile multipartFile) throws IOException {
        Goods goods = new Goods(goodName, goodDesc, price, category);
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
        List<Goods> men = goodsRepo.findAllByCategory(1);
        model.addAttribute("men", men);

        List<Goods> women = goodsRepo.findAllByCategory(2);
        model.addAttribute("women", women);

        List<Goods> children = goodsRepo.findAllByCategory(3);
        model.addAttribute("children", children);
        return "catalog";
    }

    @GetMapping("/catalog/{id}")
    public String catalogView(@PathVariable String id, Model model){
        Long long_id = Long.parseLong(id);
        Goods good = goodsRepo.findById(long_id).get();
        model.addAttribute("good", good);
        return "catalogView";
    }

    @GetMapping("/categories")
    public String test1(Model model){

        Iterable<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories", categories);

        return "categories";
    }

    @PostMapping("/deleteGood")
    public String deleteGood(@RequestParam(value = "id", required = false) Long id){
        System.out.println(id * 1000);
        goodsRepo.deleteById(id);

        return "redirect:/catalog";
    }
}
