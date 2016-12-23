package com.yezhangxin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Created by Asus on 2016/5/14.
 * 代理对象工厂�?
 */
public class ProxyFactory {

    /**
     * 静�?�工�?
     * @param realClassName 真实对象类名，需要完整的包名
     * @param proxyClassName    代理对象类名，需要完整的包名
     * @return  返回代理实例
     */
    public static Object getProxy(String realClassName,String proxyClassName) {
        Object proxy=null;
        try {
            Object realObj = Class.forName(realClassName).newInstance();
            InvocationHandler handler = (InvocationHandler) Class.forName(proxyClassName).getConstructor(realObj.getClass()).newInstance(realObj);
            proxy = Proxy.newProxyInstance(handler.getClass().getClassLoader(), realObj.getClass().getInterfaces(),
                    handler);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return proxy;
    }

}
