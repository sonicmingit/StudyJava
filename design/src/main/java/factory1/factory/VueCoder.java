package factory1.factory;

import top.sonicming.springbootdemo.design.CodeNameConstants;

/**
 * @program: SpringBootDemo
 * @description: Vue工程师
 * @author: hao.yiming
 * @create: 2020-1-16 11:30
 **/
public class VueCoder implements Coder {

    @Override
    public String getName() {
        return CodeNameConstants.VUE;
    }
    @Override
    public String coder(String name) {
        System.out.println(name + "前端工程师");
        return name + "前端工程师";
    }
}
