package factory1;

import factory1.factory.*;

/**
 * @program: SpringBootDemo
 * @description: 策略模式+工厂模式替换if/else
 * @author: hao.yiming
 * @create: 2020-1-16 9:48
 **/
public class FactoryDemo {

    /**
     * @Title: ifElse
     * @Description:  普通if-else
     * @Param: [name]
     * @return: java.lang.String
     * @Author: sonicming
     * @Date: 2020-1-16 11:11
     * @version: v1.0
    */
    public static String ifElse(String name) {
        String coder = "";
        if (CodeNameConstants.JAVA.equals(name)) {
            coder = "后端工程师";
            System.out.println(name + coder);
            return coder;
        } else if (CodeNameConstants.VUE.equals(name)) {
            coder = "前端工程师";
            System.out.println(name + coder);
            return coder;
        } else if (CodeNameConstants.PYTHON.equals(name)) {
            coder = "后端工程师";
            System.out.println(name + coder);
            return coder;
        } else if (CodeNameConstants.JAVA_SCRIPT.equals(name)) {
            coder = "前端工程师";
            System.out.println(name + coder);
            return coder;
        }else{
            coder = "未知工程师";
            return coder;
        }

    }

    public static String Factory(String name){
        if (CodeNameConstants.JAVA.equals(name)) {
            return new JavaCoder().coder(name);
        } else if (CodeNameConstants.VUE.equals(name)) {
            return new VueCoder().coder(name);
        } else if (CodeNameConstants.PYTHON.equals(name)) {
            return new PythonCoder().coder(name);
        } else if (CodeNameConstants.JAVA_SCRIPT.equals(name)) {
            return new JavaScriptCoder().coder(name);
        }else{
            return "未知工程师";
        }
    }

    public static String Factory1(String name){
        return new CoderFactory().get(name).coder(name);
    }


    public static void main(String[] args) {
        ifElse("java");
        Factory("vue");
        Factory1("python");
    }

}
