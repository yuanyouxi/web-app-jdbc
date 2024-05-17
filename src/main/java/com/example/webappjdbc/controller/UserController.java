package com.example.webappjdbc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.webappjdbc.module.mybatis.Trade;
import com.example.webappjdbc.module.mybatis.User;
import com.example.webappjdbc.service.TradeService;
import com.example.webappjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yuan Kai
 * @date 2024/5/16 15:44
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService service;
    @Autowired
    TradeService tradeServices;

    @GetMapping("select-all")
    public List<User> selectAll() {
        return service.list();
    }

    @GetMapping("select-male")
    public List<User> selectMale() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return service.list(queryWrapper.eq("SEX", true));
    }

    @GetMapping("add-user")
    @Transactional
    public boolean insert() {
        Trade trade = Trade.builder().tradeId(232312126).product("RFRXC").QTY(2000).build();
        tradeServices.save(trade);
        User user = User.builder()
                .id(4)
                .username("wangmeng")
                .sex(true)
                .age(30)
                .departmentId(2)
                .build();
        return service.save(user);
    }
}
