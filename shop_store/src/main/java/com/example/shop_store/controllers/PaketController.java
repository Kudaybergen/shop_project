package com.example.shop_store.controllers;

import com.example.shop_store.domain.Pakets;
import com.example.shop_store.repos.PaketsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/paket")
public class PaketController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private PaketsRepo paketsRepo;

    @GetMapping("/all")
    public String index(Model model){
        Iterable<Pakets> pakets = paketsRepo.findAll();
        System.out.println(pakets);
        model.addAttribute("pakets", pakets);
        return "paket/all";
    }

    @GetMapping("/add")
    public String add(){
        return "paket/add";
    }
    @PostMapping("/add")
    public String addPost(Model model, @RequestParam(value = "paketName", required = false) String paketName,
                          @RequestParam(value = "paketDesc", required = false) String paketDesc,
                          @RequestParam(value = "file", required = false) MultipartFile file,
                          @RequestParam(value = "paketPrice", required = false) float paketPrice,
                          @RequestParam(value = "paketArtikul", required = false) String paketArtikul) throws IOException {
        System.out.println(paketName);
        System.out.println(paketDesc);
        System.out.println(file);
        System.out.println(paketPrice);
        System.out.println(paketArtikul);
        Pakets pakets = new Pakets(paketName, paketArtikul, paketPrice, paketDesc);
        if (file != null){
            File someFile = new File(uploadPath);

            if (!someFile.exists()){
                someFile.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            pakets.setFilename(resultFileName);
        }
        paketsRepo.save(pakets);
        model.addAttribute("message", "new paket added");
        return "paket/add";
    }

    @PostMapping("/find")
    public String findByName(Model model,
                                 @RequestParam(value = "paketName", required = false) String paketName){
        List<Pakets> pakets = paketsRepo.findAllByName(paketName);
        System.out.println(pakets);
        model.addAttribute("pakets", pakets);
        return "all";
    }

    @GetMapping("/test")
    public String test(){
        for(int j = 1; j < 10; ++j) {

            Pakets pakets = new Pakets();
            pakets.setArtikul(j + "artikul");
            pakets.setDesc(j + "desc");
            pakets.setName(j + "name");
            pakets.setPrice(j * 10000);
            paketsRepo.save(pakets);
        }
        return "paket/test";
    }
}
