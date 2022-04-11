package com.example.demo.controller;


import com.example.demo.Mapper.CollectMapper;
import com.example.demo.Mapper.GoodMapper;
import com.example.demo.Service.CollectService;
import com.example.demo.entiy.Collect;
import com.example.demo.entiy.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@RestController
@RequestMapping("collect")
public class CollectController {
    @Autowired
    @Resource
    private CollectService collectService;
    @PostMapping("collectone")
    public void collectone(@RequestBody Collect collect){
        collectService.collectone(collect);
    }

    @GetMapping("getcollect/{id}")
    public List<Good> getcollect(@PathVariable("id")int custid){
        return collectService.getcollect(custid);
    }

    @DeleteMapping("cancelcollect/{id}")
    public void cancelcollect(@PathVariable("id") int id){
        collectService.cancelcollect(id);
    }


}
