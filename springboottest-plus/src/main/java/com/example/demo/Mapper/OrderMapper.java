package com.example.demo.Mapper;

import com.example.demo.entiy.Good;
import com.example.demo.entiy.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.GET;
import java.util.List;


public interface OrderMapper {
    @Update("insert into orderr(custid,conditio,tel,address,number,goodname) VALUES (#{custid}, #{conditio}, #{tel},#{address},#{number},#{goodname});")
    @Transactional
    void save(Order order);
    @Update("UPDATE `test`.`orderr` SET `conditio` = '商家确认' WHERE `Id` = #{id};")
    void change1(int id);
    @Update("UPDATE `test`.`orderr` SET `conditio` = '备货完成' WHERE `Id` = #{id};")
    void change2(int id);
    @Update("UPDATE `test`.`orderr` SET `conditio` = '开始发货' WHERE `Id` = #{id};")
    void change3(int id);
    @Update("UPDATE `test`.`orderr` SET `conditio` = '交易完成' WHERE `Id` = #{id};")
    void change4(int id);
    @Select("select `goodname` from `orderr` WHERE `Id` = #{id};")
    String gname(int id);
    @Select("select `custname` from `orderr` WHERE `Id` = #{id};")
    String cname(int id);
    @Select("select * from `orderr` WHERE `custid` = #{custId};")
    List<Order> custseeorder(String custId);
    @Select("select * from `orderr`;")
    List<Order> userseeorder();
    @Delete("DELETE FROM `orderr` WHERE `Id` = #{id}")
    void deleteorder(int id);


}
