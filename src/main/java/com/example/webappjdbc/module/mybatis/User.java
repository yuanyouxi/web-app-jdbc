package com.example.webappjdbc.module.mybatis;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @author Yuan Kai
 * @date 2024/5/6 09:49
 */
@Data
@TableName("USERS")
@Builder
public class User {
    @TableId("ID")
    Integer id;
    @TableField("USERNAME")
    String username;
    @TableField("SEX")
    boolean sex;
    @TableField("AGE")
    Integer age;
    @TableField("DEPARTMENTID")
    Integer departmentId;
}
