package com.sirius.controller;


import com.sirius.entity.Account;
import com.sirius.entity.Admin;
import com.sirius.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@RequestMapping("/admin/account")
@RestController
public class AccountHandler {
    @Value("${server.port}")
    private String port;

    @Autowired
    private AccountFeign accountFeign;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @PostMapping("/login")
    public String login(@RequestBody Account verify, HttpSession session){
        String username = verify.getUsername();
        String password = verify.getPassword();
        Object obj = accountFeign.login(username,password,"admin");
        if(obj == null) {
            //Log in failed
            return "0";
        }
        else {
            //Log in successfully
            Admin admin = convertAdmin((LinkedHashMap<String, Object>) obj);
            session.setAttribute("admin",admin);
            return "1";
        }
    }

    public Admin convertAdmin(LinkedHashMap<String,Object> hashMap){
        Admin admin = new Admin();
        admin.setId(((Integer)hashMap.get("id")).longValue());
        admin.setUsername((String)hashMap.get("username"));
        admin.setEmail((String)hashMap.get("email"));
        admin.setPassword((String)hashMap.get("password"));
        return admin;
    }

}