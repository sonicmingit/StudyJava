package top.sonic.java8;

/**
 * @program: StudyJavaSE
 * @description: 接口静态方法
 * @author: hao.yiming
 * @create: 2020-1-17 17:13
 **/
public interface InterfaceStaticMethod {

    default void defaultMethod(){
        System.out.println("默认方法,能继承,能重写");
    }

    static void staticMethod(){
        System.out.println("接口可以创建静态方法了,只能接口本身调用,不能继承,不能重写");
    }
}
