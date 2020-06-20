package com.sirius.controller;

import com.sirius.entity.Menu;
import com.sirius.entity.Order;
import com.sirius.entity.Restaurant;
import com.sirius.entity.Review;
import com.sirius.feign.AccountFeign;
import com.sirius.feign.MenuFeign;
import com.sirius.feign.OrderFeign;
import com.sirius.feign.ReviewFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("client/home")
@RestController
public class HomePageHandler {

    @Autowired
    private AccountFeign accountFeign;

    @Autowired
    private ReviewFeign reviewFeign;

    @Autowired
    private MenuFeign menuFeign;

    @Autowired
    private OrderFeign orderFeign;

    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping("/findallrest")
    public List<Restaurant> findAllRestaurant(){
        return accountFeign.findAllRestaurant();
    }

    @GetMapping("/findreviewbyrname/{rname}")
    public List<Review> findOrderReviewByRname(@PathVariable String rname){
        return reviewFeign.findByRestName(rname);
    }

    @GetMapping("/moreinfo/{rname}")
    public Map<String,Object> findRestMenuByRname(@PathVariable String rname){
        Map<String,Object> hashmap = new HashMap<String,Object>();
        List<Menu> menus = menuFeign.findMenuByRestName(rname);
        Restaurant restaurant = accountFeign.findRestaurantByRname(rname);
        hashmap.put("menus",menus);
        insertRestaurantToMap(hashmap,restaurant);
        return hashmap;
    }

    @GetMapping("/findmenubyrname/{rname}")
    public List<Menu> findMenuByRname(@PathVariable String rname){
        return menuFeign.findMenuByRestName(rname);
    }

    @PostMapping("/makeorder")
    public void makeOrder(@RequestBody Order order){
        orderFeign.makeOrder(order);
    }

    public void insertRestaurantToMap(Map hashmap,Restaurant restaurant){
        hashmap.put("id",restaurant.getId());
        hashmap.put("username",restaurant.getUsername());
        hashmap.put("password",restaurant.getPassword());
        hashmap.put("storename",restaurant.getStorename());
        hashmap.put("telephone",restaurant.getTelephone());
        hashmap.put("address",restaurant.getAddress());
        hashmap.put("rating",restaurant.getRating());
        hashmap.put("description",restaurant.getDescription());
        hashmap.put("state",restaurant.getState());
        hashmap.put("persontime",restaurant.getPersontime());
    }

}
