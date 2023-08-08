package com.asm.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductAdController {
    
    @RequestMapping("/admin/product/list")
    public String list(){
        return "admin/list/product";
    }
    
    @RequestMapping("/admin/product/add")
    public String add(){
        return "admin/manage/product";
    }
}
