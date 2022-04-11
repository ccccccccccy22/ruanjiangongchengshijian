package com.example.demo.Mapper;

import com.example.demo.entiy.Collect;
import com.example.demo.entiy.Customer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface CollectMapper {
    @Update("insert into collect(custid,goodid) VALUES (#{custid}, #{goodid});")
    @Transactional
    void save(Collect collect);

    @Select("select goodid from collect where custid = #{id};")
    List<Integer> getcollect(int id);
    @Select("select * from collect where custid = #{id};")
    ArrayList<Collect> getcollect2(int id);

    @Delete("DELETE FROM `collect` WHERE `Id` = #{id}")
    void cancelcollect(int id);
}
