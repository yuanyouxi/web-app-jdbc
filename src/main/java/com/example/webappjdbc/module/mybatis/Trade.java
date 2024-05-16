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
@TableName("TRADE")
@Builder
public class Trade {
    @TableId("tradeid")
    Integer tradeId;
    String product;
    @TableField("QTY")
    Integer QTY;
}
