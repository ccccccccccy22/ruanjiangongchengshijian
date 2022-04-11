package com.example.demo.Service;

import com.example.demo.Mapper.BuyCarMapper;
import com.example.demo.Mapper.GoodMapper;
import com.example.demo.entiy.BuyCar;
import com.example.demo.entiy.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuyCaeService {
    @Autowired
    @Resource
    private BuyCarMapper buyCarMapper;
    @Resource
    private GoodMapper goodMapper;

    public void addbuycar(BuyCar buyCar){
        System.out.println(buyCar.getCustid());
        buyCarMapper.save(buyCar);
    }

    public List<Good> getbuycar(int custid){
        ArrayList<Good> glist=new ArrayList<Good>();
        Good good=null;
        ArrayList<BuyCar> blist=buyCarMapper.getbuycar2(custid);
        for(int i=0;i<blist.size();i++){
            good=goodMapper.find3(blist.get(i).getGoodid());
            good.setNumber(blist.get(i).getId());
            glist.add(good);
        }
        return glist;
    }

    public void cancelbuycar(int id){
        buyCarMapper.cancelbuycar(id);
    }
}
