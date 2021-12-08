package main.proxy.dynamic;

import main.proxy.dynamic.proxy.DynamicProxy;
import org.springframework.aop.ProxyMethodInvocation;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试代理方法
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-12-24 16:57
 **/
public class DynamicTest {
    public static void main(String[] args) {
        // 被代理类
        DynamicService dynamicService = new DynamicServiceImpl();
        // 创建代理方法
        DynamicProxy proxy = new DynamicProxy(dynamicService);
        // 获取对应代理类
        DynamicService dynamicProxy = (DynamicService) proxy.getProxy();
        // 通过代理类执行被代理类方法(同时执行了增强方法)
        dynamicProxy.doSomeThing();
        /**
         * 可以生成任意方法的代理类
         */
        DynamicProxy list = new DynamicProxy(new ArrayList());
        List listProxy = (List) list.getProxy();
        listProxy.add("1");
    }
}