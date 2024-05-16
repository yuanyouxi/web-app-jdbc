package com.example.webappjdbc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.webappjdbc.module.mybatis.Trade;
import com.example.webappjdbc.service.TradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yuan Kai
 * @date 2024/5/6 09:54
 */
@RestController
@RequestMapping("mybatis")
@Slf4j
public class MybatisController {
    TradeService service;

    @Autowired
    public void setService(TradeService service) {
        this.service = service;
    }

    @GetMapping("select-all")
    public List<Trade> selectAll() {
        return service.list();
    }

    @GetMapping("insert")
    public boolean insert() {
        Trade trade = Trade.builder().tradeId(232312126).product("RFRXC").QTY(2000).build();
        return service.save(trade);
    }

    @GetMapping("update")
    public boolean update() {
        Trade trade = Trade.builder().tradeId(232312126).product("RFSXC").QTY(200010000).build();
        return service.updateById(trade);
    }

    @GetMapping("delete")
    public boolean delete() {
        return service.remove(new QueryWrapper<Trade>().eq("tradeid", 232312126));
    }

    @GetMapping("tx")
    @Transactional
    public List<Trade> tx() {
//        service.list();
//        Trade trade = Trade.builder().tradeId(232312125).product("RFSXC").QTY(1001).build();
//        service.updateById(trade);
//        service.list();
//        trade = Trade.builder().tradeId(232312126).product("RFRXC").QTY(2000).build();
//        service.save(trade);
        UpdateWrapper<Trade> wrapper = new UpdateWrapper<>();
        wrapper.eq("tradeId", 232312125);
        wrapper.setSql("QTY=QTY+1");
        service.update(wrapper);
//        try {
//            Thread.sleep(5 * 1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return service.list();
    }

    @GetMapping("tx-abort")
    @Transactional
    public List<Trade> txAbort() {
        Trade trade = Trade.builder().tradeId(232312125).product("RFSXC").QTY(10010000).build();
        service.updateById(trade);
        service.list();
        throw new RuntimeException();
    }

    @GetMapping("select-all-100x")
    @Transactional
    public List<Trade> selectAll100X() {
        UpdateWrapper<Trade> wrapper = new UpdateWrapper<>();
        wrapper.eq("tradeId", 232312124);
        wrapper.setSql("QTY=20000");
        service.update(wrapper);
        for (int i = 0; i < 100; i++) {
            List<Trade> list = service.list();
            log.info(list.toString());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Query: " + i);
        }
        return service.list();
    }
    @GetMapping("lb")
    public List<Trade> lb() {
        for (int i = 0; i < 100; i++) {
            List<Trade> list = service.list();
            log.info(list.toString());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Query: " + i);
        }
        return service.list();
    }
}
