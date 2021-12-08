package main.proxy.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 可以为一组类创建相同的增强代理方法
 * 动态代理并不存在代理类, 代理对象直接由代理生成工具动态生成.
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-12-24 16:53
 **/
public class DynamicProxy implements InvocationHandler {
    /**
     *  目标对象
     */
    private Object target;

    /**
     *  构造方法注入代理对象
     */
    public DynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 生成代理类
      */
    public Object getProxy(){
        // ClassLoader loader,Class<?>[] interfaces,InvocationHandler h
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 先执行增强方法
        before();
        // 通过动态代理执行被代理类方法
        return method.invoke(target, args);
    }


    private void before(){
        System.out.println("动态代理增强方法!");
    }
}