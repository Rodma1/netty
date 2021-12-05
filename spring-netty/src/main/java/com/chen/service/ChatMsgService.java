package com.chen.service;

import com.chen.pojo.dao.ChatMsg;
import com.chen.vo.Result;
import com.chen.vo.params.ChatMsgParam;

import java.util.List;

public interface ChatMsgService {
    /**
     * @Description: 保存聊天消息到数据库
     */
    public long saveMsg(ChatMsgParam chatMsgParam);
    /**
     * 获取为签收的消息列表
     * param：接收消息的用户id
     */
    public Result getNotReadMsgList(String acceptUserId);
}
