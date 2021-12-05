package com.chen.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Result里面是返回的json数据
@Data
//所有有参构造器
@AllArgsConstructor
//无参构造器
@NoArgsConstructor
//设置需要返回的属性
public class Result {
//    请求是否成功
    private boolean success;
//    状态码
    private Integer code;
//    参数
    private String msg;
//    数据库数据
    private Object data;
//    返回JSON数据类型
    public static Result success(Object data){
        return new Result(true,200,"success",data);
    }
//    如果请求失败
    public static Result fail(Integer code,String msg){
        return new Result(false,code,msg,null);
    }
}
