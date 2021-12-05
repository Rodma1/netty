package com.chen.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.chen.service.ChatMsgService;
import com.chen.vo.Result;
import com.chen.vo.params.ChatMsgParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.RelationSupport;

@RestController
@RequestMapping("chat")
public class ChatMsgController {
    @Autowired
    private ChatMsgService chatMsgService;
    /**
     * 保存聊天消息
     */
    @PostMapping("/saveChat")
    public long saveMsg(@RequestBody ChatMsgParam chatMsgParam){
        return chatMsgService.saveMsg(chatMsgParam);

    }
    /**
     * 获取指定用户获取未签收的消息列表
     */
    @PostMapping("/nread")
    public Result getNotReadMsgList(String acceptUserId){
        // userId 判断不能为空
        if (StringUtils.isBlank(acceptUserId)) {
            return Result.fail(400,"id不能为空");
        }
//        查询列表
        return chatMsgService.getNotReadMsgList(acceptUserId);
    }

}
