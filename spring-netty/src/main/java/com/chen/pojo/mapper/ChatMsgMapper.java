package com.chen.pojo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.pojo.dao.ChatMsg;

import java.util.List;

public interface ChatMsgMapper extends BaseMapper<ChatMsg> {
//    批量更新消息状态
    public void batchUpdateMsgSigned(List<Long> msgIdList);
}
