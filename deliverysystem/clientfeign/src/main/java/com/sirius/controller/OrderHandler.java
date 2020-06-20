package com.sirius.controller;

import com.sirius.entity.Order;
import com.sirius.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/order")
public class OrderHandler {
    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/findallorder")
    public List<Order> findAllOrder(){
        return orderFeign.findAllOrder();
    }

    @PutMapping("/receiveaction/{oid}")
    public void receiveAction(@PathVariable long oid){
        orderFeign.receiveAction(oid);
    }



}
