package com.chen.pojo.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data

public class ChatMsg {
//    如果不加使用的是分布式id
//    @TableId(type = IdType.AUTO)
    private Long id;

    private String sendUserId;

    private String acceptUserId;

    private String msg;

    /**
     * 消息是否签收状态
     * 1：签收
     * 0：未签收
     */
    private Integer signFlag;

    /**
     * 发送请求的事件
     */
    private Date createTime;
}
