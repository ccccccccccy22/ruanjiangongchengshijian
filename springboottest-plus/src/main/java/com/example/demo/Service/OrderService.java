package com.example.demo.Service;

import com.example.demo.Mapper.CustMapper;
import com.example.demo.Mapper.GoodMapper;
import com.example.demo.Mapper.HisGoodMapper;
import com.example.demo.Mapper.OrderMapper;
import com.example.demo.entiy.CustomerZC;
import com.example.demo.entiy.Good;
import com.example.demo.entiy.HisGood;
import com.example.demo.entiy.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private GoodMapper goodMapper;

    @Resource
    private CustMapper custMapper;
    @Resource
    private HisGoodMapper hisGoodMapper;

    public void deleteorder(int id){

        String gname=orderMapper.gname(id);
        int gnum=goodMapper.getgoodnum(gname);
        gnum++;
        goodMapper.number(gnum,gname);
        orderMapper.deleteorder(id);
    }

    public void change2(int id){
        String gname=orderMapper.gname(id);
        int gnum=goodMapper.getgoodnum(gname);
        gnum--;
        goodMapper.number(gnum,gname);
        orderMapper.change2(id);
    }

    public void change4(int id){
        String gname=orderMapper.gname(id);
        Good good=goodMapper.find2(gname);
        HisGood hisg=new HisGood();
        hisg.setName(good.getName());
        hisg.setNumber(1);
        hisg.setPrice(good.getPrice());
        hisg.setUrl(good.getUrl());
        hisg.setInformation(good.getInformation());
        String cname=orderMapper.cname(id);
        CustomerZC cust=custMapper.find(cname);
        System.out.println(cust.getCustname());
        hisg.setAddress(cust.getAddress());
        hisg.setCustname(cname);
        hisGoodMapper.save(hisg);
        orderMapper.change4(id);
    }

    public List<Order> userseeorder() {
        return orderMapper.userseeorder();
    }

    public void addOrder(Order order){
        orderMapper.save(order);
    }

    public void change1(int id){
        orderMapper.change1(id);
    }
    public void change3(int id){
        orderMapper.change3(id);
    }

    public List<Order> custseeorder(String custId){
        return orderMapper.custseeorder(custId);
    }

}
