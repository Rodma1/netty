package com.chen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.chen.enums.MsgSignFlagEnum;
import com.chen.pojo.dao.ChatMsg;
import com.chen.pojo.mapper.ChatMsgMapper;
import com.chen.service.ChatMsgService;
import com.chen.vo.Result;
import com.chen.vo.params.ChatMsgParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        ChatMsg chat = new ChatMsg();
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

    /**
     * 获取未签收的消息列表
     * param：接收消息的用户id
     *
     * @param acceptUserId
     */
    @Override
    public Result getNotReadMsgList(String acceptUserId) {
//        初始化mapper映射,查询Article数据表的信息
        LambdaQueryWrapper<ChatMsg> queryWrapper = new LambdaQueryWrapper<>();
//        状态为零
        queryWrapper.eq(ChatMsg::getSignFlag, 0);
//        接收消息的用户id
        queryWrapper.eq(ChatMsg::getAcceptUserId, acceptUserId);
//        获取列表

        return Result.success(chatMsgMapper.selectList(queryWrapper));
    }

    /**
     * 批量更新消息
     *
     * @param msgIdsStr
     * @return
     */
    @Override
    public Result updateMsgList(String msgIdsStr) {
//        List list = Arrays.asList(s.split(","));
//        通过，分割成数组
        String msgIds[] = msgIdsStr.split(",");
//        转变成动态数组
        List<Long> msgIdList = new ArrayList<>();
        for (String mid : msgIds) {
            if (StringUtils.isNotBlank(mid)) {
//                转变成long类型
                msgIdList.add(Long.parseLong(mid));
            }
        }
//        更新消息
        if (msgIdList != null && !msgIdList.isEmpty() && msgIdList.size() > 0) {
//            批量更新
            chatMsgMapper.batchUpdateMsgSigned(msgIdList);
        }
        return Result.success("更新成功");
    }
}
