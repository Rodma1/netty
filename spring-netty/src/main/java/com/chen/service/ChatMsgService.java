package com.chen.service;

import com.chen.vo.params.ChatMsgParam;

public interface ChatMsgService {
    /**
     * @Description: 保存聊天消息到数据库
     */
    public long saveMsg(ChatMsgParam chatMsgParam);
}
