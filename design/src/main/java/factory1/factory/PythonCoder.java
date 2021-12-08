package factory1.factory;

import top.sonicming.springbootdemo.design.CodeNameConstants;

/**
 * @program: SpringBootDemo
 * @description: python工程师
 * @author: hao.yiming
 * @create: 2020-1-16 11:29
 **/
public class PythonCoder implements Coder{
    @Override
    public String getName() {
        return CodeNameConstants.PYTHON;
    }

    @Override
    public String coder(String name) {
        System.out.println(name + "后端工程师");
        return name + "后端工程师";
    }
}
