package com.chen.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.chen.netty.WebSorketServer;

/**
 * 在IOC容器的启动过程，当所有的bean都已经处理完成之后，spring ioc容器会有一个发布事件的动作
 * 让我们的bean实现APplicationListener接口，这样当发布事件时，[spring]的ioc容器就会以容器的实列对象作为事件源类，
 * 并从中找到事件的监听者，此时applicationListener接口实例中的onApplicationEvent(E event) 方法就会被调用
 */
@Component
@Slf4j
public class NettyBooter implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent()==null) {
			try {
//				调用WSServer，就可以绑定接口，服务就启动了
				WebSorketServer webSorketServer=new WebSorketServer();
				webSorketServer.start();
			} catch (Exception e) {
				log.info("异常："+e);
			}
		}
	}

}