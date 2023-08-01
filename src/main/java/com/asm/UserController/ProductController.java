package com.asm.UserController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.entity.Product;
import com.asm.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/product/list")
    public String list(Model model, @RequestParam("cid") Optional<String> cid,
            @RequestParam("gender") Optional<String> gender) {
        if (cid.isPresent()) {
            List<Product> list = new ArrayList<Product>();
            if (gender.get().equalsIgnoreCase("male")) {
                list = productService.findByidAndGender(cid.get(),true);
            } else {
                list = productService.findByidAndGender(cid.get(),false);
            }
            model.addAttribute("items", list);

        } else {
            List<Product> list = productService.findAll();
            model.addAttribute("items", list);
        }
        return "user/product/list";
    }

    @RequestMapping("/product/bestseller")
    public String bestseller(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("items", list);
        return "user/product/list";
    }
}
