package sonic.testst;


import org.apache.commons.lang3.ArrayUtils;

/**
 * @author: sonic.hao(ºÂÒ»Ãù)
 * @date: 2021/8/31 18:33
 **/
public class ArrContains {

    public static void main(String[] args) {

        String o = "207";
        long a1 = System.currentTimeMillis();
        boolean contains = ArrayUtils.contains(new String[]{"207", "208", "209", "210", "211", "212"}, o);
if (contains){
    System.out.println("555");
}
        long a2 = System.currentTimeMillis();
        System.out.println(a2-a1);

        long b1 = System.currentTimeMillis();
        if ("207".equalsIgnoreCase(o)
        ||"208".equalsIgnoreCase(o)
        ||"209".equalsIgnoreCase(o)
        ||"210".equalsIgnoreCase(o)
        ||"211".equalsIgnoreCase(o)
        ||"212".equalsIgnoreCase(o)
        ){
            System.out.println("666");
        }
        long b2 = System.currentTimeMillis();
        System.out.println(b2-b1);


    }




}