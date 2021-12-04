package com.chen.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 设置netty启动
 * AIO模型
 */
@Slf4j
@Component
public class WebSorketServer {


    //    主线程池
    private EventLoopGroup mainGroup;
    //    从线程池
    private EventLoopGroup subGroup;
    //    启动类
    private ServerBootstrap server;
    //    通道
    private ChannelFuture future;

    public WebSorketServer() {
        mainGroup = new NioEventLoopGroup();
        subGroup = new NioEventLoopGroup();
//        启动服务
        server = new ServerBootstrap();
        server.group(mainGroup, subGroup)
                .channel(NioServerSocketChannel.class)//通道
                .childHandler(new WSServerInitialzer());//自定义子处理器

    }
//    启动服务
    public  void start(){
        this.future=server.bind(8088);
        log.info("netty websocket server 启动完毕...");
    }
}
