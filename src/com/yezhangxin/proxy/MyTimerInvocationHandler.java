package com.yezhangxin.proxy;

import com.yezhangxin.utils.MyUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public abstract class MyTimerInvocationHandler implements InvocationHandler{
    private Object widgetTimer;
    private MyUtil myUtil;
    private Object resultObject;
    private long startTime;
    private long endTime;
    private long consumeTime;

    public MyTimerInvocationHandler(Object widgetTimer) {
        this.widgetTimer = widgetTimer;
        this.myUtil = new MyUtil();
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        myUtil.p("鍑芥暟鍚�?:" + method);
        startTime=System.currentTimeMillis();
        myUtil.p("璧峰鏃堕棿:" + startTime);
        resultObject=method.invoke(widgetTimer, args);
        endTime=System.currentTimeMillis();
        myUtil.p("缁撴潫鏃堕棿:" + endTime);
        consumeTime=endTime-startTime;
        myUtil.p("鍑芥暟鑰楁椂:" + consumeTime + "ms");
        return resultObject;
    }

}
