package com.chen.vo.params;

import lombok.Data;

import java.io.Serializable;
//存储前端发送过来的数据
@Data
public class DataContent implements Serializable {

    private Integer action;		// 动作类型
    private ChatMsgParam chatMsgParam;	// 用户的聊天内容entity
    private String extand;		// 扩展字段

}
