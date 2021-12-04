package com.chen.netty;


import com.chen.enums.MsgActionEnum;
import com.chen.pojo.dao.DataContent;
import com.chen.utils.JsonUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * @Description: 处理消息的handler
 * TextWebSocketFrame： 在netty中，是用于为websocket专门处理文本的对象，frame是消息的载体
 */
@Slf4j
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    //    用于记录和管理所有客户端的channle
    public static ChannelGroup users = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext chc, TextWebSocketFrame twsf) throws Exception {

//       1.  获取客户端传输过来的消息
        String content = twsf.text();
        log.info("读取客户端发来的消息："+content);
//        获取客户端通道
        Channel currentChannel = chc.channel();
//      将获取的数据转为json格式，对应dataContent字段
        DataContent dataContent= JsonUtils.jsonToPojo(content,DataContent.class);
//        获取状态
        Integer action= dataContent.getAction();
//        2。判断消息类型，根据不同的类型来处理不同的业务
        if (action== MsgActionEnum.CONNECT.type){
//          2.1  当websocket 第一次open的时候，初始化channel，把用的channel和userid关联起来
            String senderId=dataContent.getChatMsg().getSenderId();//获取发送者id
//            通过hash将用户id和通道关联起来
            UserChannelHash.put(senderId,currentChannel);
// 测试
            for (Channel c : users) {
                System.out.println(c.id().asLongText());
            }
            UserChannelHash.output();
        }else{
            // 将数据刷新到客户端上
            users.writeAndFlush(
                    new TextWebSocketFrame(
                            "[服务器在]" + LocalDateTime.now()
                                    + "接受到消息, 消息为：" + content));

        }
    }

    /**
     * 当客户端连接服务端之后（打开连接）
     * 获取客户端的channle，并且放到ChannelGroup中去进行管理
     */
//    继承ChannelHandlerAdapter
    @Override
    public void handlerAdded(ChannelHandlerContext context) throws Exception {
        log.info("添加了一个通道");
        users.add(context.channel());
    }

    //    移除与客户端的连接
    @Override
    public void handlerRemoved(ChannelHandlerContext context) throws Exception {
        String channelId = context.channel().id().asShortText();
        log.info("客户端被移除,channelId为：" + channelId);
        // 当触发handlerRemoved，ChannelGroup会自动移除对应客户端的channel
        users.remove(context.channel());
    }

    //    异常关闭
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        // 发生异常之后关闭连接（关闭channel），随后从ChannelGroup中移除
        ctx.channel().close();
        users.remove(ctx.channel());
    }

}
