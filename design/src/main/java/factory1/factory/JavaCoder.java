package factory1.factory;


import top.sonicming.springbootdemo.design.CodeNameConstants;

/**
 * @program: SpringBootDemo
 * @description: Java工程师
 * @author: hao.yiming
 * @create: 2020-1-16 11:19
 **/
public class JavaCoder implements Coder {

    @Override
    public String getName() {
        return CodeNameConstants.JAVA;
    }

    @Override
    public String coder(String name) {
        System.out.println(name + "后端工程师");
        return name + "后端工程师";
    }
}
