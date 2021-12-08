package main.proxy.dynamic;

/**
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-12-24 16:50
 **/
public class DynamicServiceImpl implements DynamicService {
    @Override
    public void doSomeThing() {
        System.out.println("实现类方法!");
    }
}