package com.sirius.controller;


import com.sirius.entity.Account;
import com.sirius.entity.Restaurant;
import com.sirius.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@RequestMapping("/restaurant")
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
        Object obj = accountFeign.login(username,password,"restaurant");
        if(obj == null) {
            //Log in failed
            return "0";
        }
        else {
            //Log in successfully
            Restaurant restaurant = convertRest((LinkedHashMap<String, Object>) obj);
            session.setAttribute("restaurant",restaurant);
            return "1";
        }
    }

    public Restaurant convertRest(LinkedHashMap<String,Object> hashMap){
        Restaurant restaurant = new Restaurant();
        restaurant.setId(((Integer)hashMap.get("id")).longValue());
        restaurant.setUsername((String)hashMap.get("username"));
        restaurant.setStorename((String)hashMap.get("storename"));
        restaurant.setPassword((String)hashMap.get("password"));
        restaurant.setAddress((String)hashMap.get("address"));
        restaurant.setDiscription((String)hashMap.get("discription"));
        restaurant.setRating((int)hashMap.get("rating"));
        restaurant.setTelephone((String)hashMap.get("telephone"));
        return restaurant;
    }

}