package com.chen.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
 
/**
 * spring上下文获取springbean
 * 提供手动获取被spring管理的bean对象
 * https://blog.csdn.net/weixin_37545129/article/details/111905992
 */
@Configuration//非常重要
public class SpringBeanUtil implements ApplicationContextAware {
 
    private static ApplicationContext applicationContext = null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanUtil.applicationContext = applicationContext;
    }
    public static Object getBeanByName(String beanName){
        if(applicationContext == null){
            return null;
        }
        return applicationContext.getBean(beanName);
    }
    public static <T> T getBean(Class<T> type) {
        return applicationContext.getBean(type);
    }
 
}
