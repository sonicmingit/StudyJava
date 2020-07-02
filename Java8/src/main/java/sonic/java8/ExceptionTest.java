package sonic.java8;

/**
 * @program: StudyJavaSE
 * @description: 异常测试
 * @author: hao.yiming
 * @create: 2020-4-1 20:21
 **/
public class ExceptionTest {

    public static void main(String[] args) {
        try {
            System.out.println("11111");
            throw           new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("222222");
        }
        System.out.println("33333");

    }
}

