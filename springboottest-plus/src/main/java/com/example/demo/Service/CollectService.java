package com.example.demo.Service;

import com.example.demo.Mapper.CollectMapper;
import com.example.demo.Mapper.GoodMapper;
import com.example.demo.entiy.Collect;
import com.example.demo.entiy.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollectService {
    @Autowired
    @Resource
    private CollectMapper collectMapper;
    @Resource
    private GoodMapper goodMapper;

    public void collectone(Collect collect){
        collectMapper.save(collect);
    }

    public List<Good> getcollect(int custid){
        ArrayList<Good> glist=new ArrayList<Good>();
        Good good=null;
        ArrayList<Collect> clist=collectMapper.getcollect2(custid);
        for(int i=0;i<clist.size();i++){
            good=goodMapper.find3(clist.get(i).getGoodid());
            good.setNumber(clist.get(i).getId());
            glist.add(good);
        }
        return glist;
    }

    public void cancelcollect(int id){
        collectMapper.cancelcollect(id);
    }
}
