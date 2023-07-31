package com.asm.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    
    @RequestMapping("/product/list")
    public String list(){
        return "user/product/list";
    }
}
