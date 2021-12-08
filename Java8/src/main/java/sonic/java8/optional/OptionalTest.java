package sonic.java8.optional;
import org.junit.Test;
import sonic.a.datatype.cars;
import sonic.pojo.Ok;
import sonic.pojo.OkSub1;
import sonic.pojo.OkSub11;
import sonic.pojo.OkSub2;

import java.util.Optional;
/**
 * 测试Optional
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-5-26 11:01
 **/
public class OptionalTest {


    public static void main(String args[]){

        OptionalTest java8Tester = new OptionalTest();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(java8Tester.sum(a,b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }

    @Test
    public void test1(){
        String a = "";
        String b = "123";
        Integer ainteger = Optional.ofNullable(a).map(aa -> aa.length()).orElse(0);
        Integer binteger = Optional.ofNullable(b).map(String::length).orElse(0);
        System.out.println(ainteger);
        System.out.println(binteger);
    }

    @Test
    public void test2(){

        Ok ok = new Ok();
        Optional<OkSub11> okSub11 = Optional.ofNullable(ok).map(Ok::getOk1).map(OkSub1::getOk11);
        Integer integer = Optional.ofNullable(ok).map(Ok::getOk1).map(OkSub1::getOk11).map(OkSub11::getOkInt).orElse(1);
    }



    @Test
    public void test(){
        String mobile = "lkjsdf 法师多了空间发生的  .,的说法说带飞了空间看了三..四大皆空. .,的说法,水电费,4544131....    ";
        String[] recipients = mobile.split(",");
        //目标号码组，必填参数
        String mobiles = "";
        int a = 1;
        for (String string : recipients) {
            if (a == 1) {
                mobiles = string;
            }else {
                mobiles = mobiles +","+ string;
            }
            a++;
        }

        System.out.println(mobiles);
        System.out.println(mobile.equals(mobiles));
    }

}