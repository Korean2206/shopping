package com.asm.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
    
    @RequestMapping("/account/login")
    public String login(){
        return "user/account/login";
    }
    @RequestMapping("/account/register")
    public String register(){
        return "user/account/register";
    }
    @RequestMapping("/account/profile")
    public String profile(){
        return "user/account/profile";
    }
}
