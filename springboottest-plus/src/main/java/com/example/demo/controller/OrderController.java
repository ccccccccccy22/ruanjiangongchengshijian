package com.example.demo.controller;

import com.example.demo.Service.OrderService;
import com.example.demo.entiy.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    @Resource
    private OrderService orderService;
    @PostMapping("insert")
    public void addOrder(@RequestBody Order order){
        orderService.addOrder(order);
    }
    @PostMapping("change1/{Id}")
    public void change1(@PathVariable("Id")int id){
        orderService.change1(id);
    }
    @PostMapping("change2/{Id}")
    public void change2(@PathVariable("Id")int id){
       orderService.change2(id);
    }
    @PostMapping("change3/{Id}")
    public void change3(@PathVariable("Id")int id){
        orderService.change3(id);
    }
    @PostMapping("change4/{Id}")
    public void change4(@PathVariable("Id")int id){
        orderService.change4(id);
    }
    @DeleteMapping("delete/{Id}")
    public void deleteorder(@PathVariable("Id")int id){
        orderService.deleteorder(id);
    }

    @GetMapping("custseeorder/{custId}")
    public List<Order> custseeorder(@PathVariable("custId") String custId){
        return orderService.custseeorder(custId);
    }

    @GetMapping("userseeorder")
    public List<Order> userseeorder(){
        return orderService.userseeorder();
    }


}
