package com.chen.netty;


import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 用户id和channel的关联关系处理
 * 第一时间想到的就是键值对
 */
@Slf4j
public class UserChannelHash {
    private static HashMap<String, Channel> hashMap=new HashMap<>();
//    存入hash
    public static void put(String senderId,Channel channel){
        hashMap.put(senderId,channel);
    }
//    获取值
    public static void get(String senderId){
        hashMap.get(senderId);
    }
//    输出
    public static void output(){
        for(HashMap.Entry<String,Channel> entry:hashMap.entrySet()){
            log.info("UserId: " + entry.getKey()
                    + ", ChannelId: " + entry.getValue().id().asLongText());
        }
    }

}
