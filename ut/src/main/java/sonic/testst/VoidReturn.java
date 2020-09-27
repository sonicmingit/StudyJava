package sonic.testst;

/**
 * 空返回return停止测试
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-9-16 10:12
 **/
public class VoidReturn {

    public static void testReturn(int i){
        System.out.println("进入方法"+i);
        if (i==1){
            System.out.println("方法停止成功"+i);
            return;
        }
        System.out.println("方法继续"+i);
    }

    public static void main(String[] args) {
        testReturn(0);
        testReturn(1);
    }
}