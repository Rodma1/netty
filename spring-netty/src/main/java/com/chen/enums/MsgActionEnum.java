package com.chen.enums;

/**
 *
 * @Description: 发送消息的动作 枚举
 */
public enum MsgActionEnum {
    CONNECT(1, "第一次(或重连)初始化连接");
    public final Integer type;
    public final String content;

    MsgActionEnum(Integer type, String content){
        this.type = type;
        this.content = content;
    }

    public Integer getType() {
        return type;
    }
    }
