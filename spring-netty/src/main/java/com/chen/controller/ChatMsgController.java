package com.chen.controller;

import com.chen.service.ChatMsgService;
import com.chen.vo.params.ChatMsgParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
