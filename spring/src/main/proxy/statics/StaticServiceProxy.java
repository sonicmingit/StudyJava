package main.proxy.statics;

/**
 * 代理模式-静态工厂
 * 缺点:所代理的类每个都得创建一个,每个方法都得写一遍
 * 为每一个业务增强都提供一个代理类, 由代理类来创建代理对象
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-12-24 16:09
 **/
public class StaticServiceProxy implements StaticService {

    public void SetStaticServiceProxy(StaticService staticService) {
        this.staticService = staticService;
    }

    public StaticServiceProxy(StaticService staticService) {
        this.staticService = staticService;
    }

    private StaticService staticService;

    @Override
    public void doSomeThing() {
        // 先调用代理的增强方法
        doSomeThing4Proxy();
        staticService.doSomeThing();
    }

    // 可以写一些代理的增强方法
    private void doSomeThing4Proxy(){
        System.out.println("代理处理一些事情");
    }

}