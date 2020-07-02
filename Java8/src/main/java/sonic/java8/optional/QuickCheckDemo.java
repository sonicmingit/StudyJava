package sonic.java8.optional;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 快速判空demo
 * https://blog.csdn.net/xhd731568849/article/details/79532959
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-5-26 11:27
 **/
public class QuickCheckDemo {

    private void testCheck(){
        TestDAO t1 = new TestDAO();
        t1.getDao1().getStrList().get(0);
    }


    private void testCheckOp(){
        TestDAO t1 = new TestDAO();
        Optional<String> s = Optional.ofNullable(t1).map(u -> u.getDao1()).map(u -> u.getStr()).map(String::toString);
    }

    @Test
    public void testOp(){
        TestDAO t = new TestDAO();
        TestDAO1 t1 = new TestDAO1();
        t.setDao1(t1);
        t1.setStrList(new ArrayList<>());
        Integer integer = Optional.ofNullable(t).map(TestDAO::getDao1).map(TestDAO1::getStrList).map(List::size).orElse(100);
        System.out.println(integer);
    }
}