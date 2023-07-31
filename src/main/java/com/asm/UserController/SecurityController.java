package com.asm.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    
    @RequestMapping("/security/login")
    public String login(){
        return "user/security/login";
    }
    @RequestMapping("/security/register")
    public String register(){
        return "user/security/register";
    }
    @RequestMapping("/security/profile")
    public String profile(){
        return "user/security/profile";
    }
}
