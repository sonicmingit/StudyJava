package main.proxy.statics;

/**
 * 实现类
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-12-24 16:10
 **/
public class StaticServiceImpl implements StaticService {
    @Override
    public void doSomeThing() {
        System.out.println("被代理的方法!");
    }
}