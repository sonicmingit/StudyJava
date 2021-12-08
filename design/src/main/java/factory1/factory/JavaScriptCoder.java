package factory1.factory;

import top.sonicming.springbootdemo.design.CodeNameConstants;

/**
 * @program: SpringBootDemo
 * @description: Javascript工程师
 * @author: hao.yiming
 * @create: 2020-1-16 11:31
 **/
public class JavaScriptCoder implements Coder {

    @Override
    public String getName() {
        return CodeNameConstants.JAVA_SCRIPT;
    }

    @Override
    public String coder(String name) {
        System.out.println(name + "前端工程师");
        return name + "前端工程师";
    }
}
