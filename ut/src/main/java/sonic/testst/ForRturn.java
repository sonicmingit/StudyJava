package sonic.testst;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * for循环中的return是否返回方法
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-9-29 9:20
 **/
public class ForRturn {

    public static void testReturn(String stop) {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        for (int i :
                list) {
            System.out.println(i);
            if (i==3&&"1".equals(stop)){
                return;
            }
        }
        System.out.println("没有停止");
    }

    public static void main(String[] args) {
        // 有for循环的情况下,for循环内return也是直接跳出方法
        testReturn("1");
    }
}