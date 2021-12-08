package main.proxy.statics;

/**
 * 调用方法
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-12-24 16:13
 **/
public class Client {

    public static void main(String[] args) {
        StaticService s = new StaticServiceImpl();
        StaticServiceProxy proxy = new StaticServiceProxy(s);
        proxy.doSomeThing();
    }
}