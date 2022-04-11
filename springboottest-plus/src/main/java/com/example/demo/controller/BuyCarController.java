package com.example.demo.controller;

import com.example.demo.Mapper.BuyCarMapper;
import com.example.demo.Mapper.GoodMapper;
import com.example.demo.Service.BuyCaeService;
import com.example.demo.entiy.BuyCar;
import com.example.demo.entiy.Collect;
import com.example.demo.entiy.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/buycar")
public class BuyCarController {
    @Autowired
    @Resource
    private BuyCaeService buyCaeService;

    @PostMapping("addbuycar")
    public void addbuycar(@RequestBody BuyCar buyCar){
        buyCaeService.addbuycar(buyCar);
    }

    @GetMapping("getbuycar/{id}")
    public List<Good> getbuycar(@PathVariable("id")int custid){
        return buyCaeService.getbuycar(custid);
    }

    @DeleteMapping("cancelbuycar/{id}")
    public void cancelbuycar(@PathVariable("id")int id){
        buyCaeService.cancelbuycar(id);
    }
}
