package com.sirius.controller;

import com.sirius.entity.Order;
import com.sirius.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderHandler {
    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        order.date = new Date();
        order.arrivingtime = new Date();
        orderRepository.save(order);
    }

    @GetMapping("/findAll")
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    @GetMapping("/findAllByUid/{uid}")
    public List<Order> findAllByUid(@PathVariable("uid") int uid){
        return orderRepository.findAllByUid(uid);
    }

    @GetMapping("/findAllByRid/{rid}")
    public List<Order> findAllByRid(@PathVariable("rid") int rid){
        return orderRepository.findAllByRid(rid);
    }

    @PutMapping("/update")
    public void update(@RequestBody Order order){
        orderRepository.update(order);
    }

    @PutMapping("/receiveaction/{oid}")
    public void receiveAction(@PathVariable("oid") long oid){
        orderRepository.receiveAction(oid);
    }

    @PutMapping("/commentaction/{oid}")
    public void commentAction(@PathVariable("oid") long oid){
        orderRepository.commentAction(oid);
    }

}
