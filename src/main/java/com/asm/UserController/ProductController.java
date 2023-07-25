package com.asm.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    
    @RequestMapping("/product/best_seller")
    public String bestSeller(){
        return "user/product/index";
    }
}
