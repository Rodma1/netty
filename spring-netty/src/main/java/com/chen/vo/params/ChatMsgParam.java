package com.chen.vo.params;

import lombok.Data;


@Data
public class ChatMsgParam {

    private String senderId;		// 发送者的用户id
    private String receiverId;		// 接受者的用户id
    private String msg;				// 聊天内容
    private String msgId;
}
