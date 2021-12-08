package main;

import main.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 控制反转/依赖注入测试
 * 对应IocAndDiConfig.xml文件
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-12-24 13:51
 **/
public class IocAndDiTest {

    public static void main(String[] args) {
        // 创建一个上下文并加载配置
        ApplicationContext ac = new ClassPathXmlApplicationContext("IocAndDiConfig.xml");
        // 获取User实例,对应配置xml bean id/name
        User user = (User) ac.getBean("user");
        // 别名获取实例
        User userName2 = (User) ac.getBean("userName2");
        // 测试输出
        System.out.println("简单注入:"+user.toString());
        System.out.println("简单别名注入:"+userName2.toString());

        /*多属性注入*/
        User user1 = ac.getBean("user1",User.class);
        System.out.println("多属性注入:"+user1);

        /*构造器构造*/
        User userCon = ac.getBean("userCon",User.class);
        System.out.println("构造器构造:"+userCon);

        /*P命名和C命名*/
        User userP = ac.getBean("userP",User.class);
        System.out.println("P命名:"+userP);
        User userC = ac.getBean("userC",User.class);
        System.out.println("C命名:"+userC);


        /*初始化方法构造*/
        User userInit = ac.getBean("userInit",User.class);
        // 销毁
        ((ClassPathXmlApplicationContext)ac).close();


    }
}