package com.example.webappjdbc.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.webappjdbc.mapper.UserMapper;
import com.example.webappjdbc.module.mybatis.User;
import org.springframework.stereotype.Service;

/**
 * @author Yuan Kai
 * @date 2024/5/16 15:43
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
}
