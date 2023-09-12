package com.example.ad.common;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class R<T> {

    // 结果状态码
    private int code;

    // 响应信息
    private String msg;

    // 响应数据
    private T data;

    // 接口请求时间
    private String datetime ;

    public R (){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        this.datetime = formatter.format(date);
    }

    public static <T> R<T> success(T data){
        R r = new R();
        r.setCode(ReturnCode.RC200.getCode());
        r.setMsg(ReturnCode.RC200.getMsg());
        r.setData(data);
        return  r;
    }

    public static <T> R<T> fail(int code, String msg){
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
}
