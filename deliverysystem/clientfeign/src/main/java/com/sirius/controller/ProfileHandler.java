package com.sirius.controller;

import com.sirius.entity.User;
import com.sirius.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client/profile")
public class ProfileHandler {
    @Autowired
    private UserFeign userFeign;

    @GetMapping("/finduserbyid/{userid}")
    public User findUserById(@PathVariable long userid){
        return userFeign.findById(userid);
    }

    @PutMapping("/editprofile")
    public void editProfile(@RequestBody User user){
        System.out.println(user);
        userFeign.editProfile(user);
    }
}
