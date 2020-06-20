package com.sirius.controller;

import com.sirius.entity.Account;
import com.sirius.entity.User;
import com.sirius.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/findById/{userid}")
    public User findById(@PathVariable("userid") int userid){
        return userRepository.findById(userid);
    }

    @GetMapping("/findByName/{nickname}")
    public User findByName(@PathVariable("nickname") String nickname){
        return userRepository.findByName(nickname);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        userRepository.save(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        User user1 = new User();
        user1.setId(user.getId());
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        user1.setAddress(user.getAddress());
        user1.setTelephone(user.getTelephone());
        user1.setNickname(user.getNickname());
        System.out.println(user);
        System.out.println(user1);
        userRepository.update(user);
    }

    @DeleteMapping("/deleteByName/{nickname}")
    public void deleteByName(@PathVariable("nickname") String nickname){
        userRepository.deleteByName(nickname);
    }

    @DeleteMapping("/deleteById/{userid}")
    public void deleteById(@PathVariable("userid") int userid){
        userRepository.deleteById(userid);
    }
}
