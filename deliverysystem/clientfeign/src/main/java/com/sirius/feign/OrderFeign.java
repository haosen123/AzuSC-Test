package com.sirius.feign;

import com.sirius.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "order")
public interface OrderFeign {
    @PostMapping("/order/save")
    public void makeOrder(@RequestBody Order order);

    @GetMapping("/order/findAll")
    public List<Order> findAllOrder();

    @PutMapping("/order/receiveaction/{oid}")
    public void receiveAction(@PathVariable("oid") long oid);
}
