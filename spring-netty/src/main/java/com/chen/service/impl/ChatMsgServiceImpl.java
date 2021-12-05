package com.chen.service.impl;

import com.chen.enums.MsgSignFlagEnum;
import com.chen.pojo.dao.ChatMsg;
import com.chen.pojo.mapper.ChatMsgMapper;
import com.chen.service.ChatMsgService;
import com.chen.vo.params.ChatMsgParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
//实现服务层的接口
@Service
public class ChatMsgServiceImpl implements ChatMsgService {

    @Autowired(required = false)
    private ChatMsgMapper chatMsgMapper;
    /**
     * @param chatMsgParam
     * @Description: 保存聊天消息到数据库
     */
    @Override
    public long saveMsg(ChatMsgParam chatMsgParam) {
        ChatMsg chat=new ChatMsg();
        chat.setAcceptUserId(chatMsgParam.getReceiverId());
        chat.setSendUserId(chatMsgParam.getSenderId());
        chat.setCreateTime(new Date());
//        未签收
        chat.setSignFlag(MsgSignFlagEnum.unsign.type);
//        聊天内容
        chat.setMsg(chatMsgParam.getMsg());
        System.out.println(chat);
        chatMsgMapper.insert(chat);


        return chat.getId();
    }
}
