package com.example.webappjdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.webappjdbc.module.mybatis.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yuan Kai
 * @date 2024/5/16 15:42
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
