package com.sirius.feign;

import com.sirius.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "user")
public interface UserFeign {
    @GetMapping("/user/findById/{userid}")
    public User findById(@PathVariable long userid);

    @PutMapping("/user/update")
    public void editProfile(@RequestBody User user);
}
