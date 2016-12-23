package com.yezhangxin.proxy;

/**
 * Created by Yzx on 2016/5/13.
 * 函数计时工具
 */
public interface WidgetTimer {
    public <T>void p(T t);
    public <T>void p(T[] t);

    public String readFile(String filePath);
}
