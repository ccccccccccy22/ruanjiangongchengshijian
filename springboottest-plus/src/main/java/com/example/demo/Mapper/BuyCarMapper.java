package com.example.demo.Mapper;

import com.example.demo.entiy.BuyCar;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface BuyCarMapper {
    @Update("insert into buycar(custid,goodid) VALUES (#{custid}, #{goodid});")
    @Transactional
    void save(BuyCar buycar);

    @Select("select goodid from buycar where custid = #{id};")
    List<Integer> getbuycar(int id);
    @Select("select * from buycar where custid = #{id};")
    ArrayList<BuyCar> getbuycar2(int id);

    @Delete("delete from buycar where id = #{id};")
    void cancelbuycar(int id);
}
