/*
package sonic.testst;

import com.alibaba.common.lang.StringUtil;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sun.deploy.util.StringUtils;

import java.util.Map;
import java.util.Set;

*/
/**
 * set判空
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-9-17 15:30
 **//*

public class setNull {

    public static void main(String[] args) {
        */
/*Set<String> set = Sets.newHashSet();
        Map<String,String> map = Maps.newHashMap();
        map.put("1","111");
        set.add(map.get("111"));
        set.add(map.get("222"));
        set.add(map.get("333"));
        set.add(map.get("1"));
        System.out.println(set.size());
        System.out.println(set);*//*



        long start = System.currentTimeMillis();
        Set<String> set = Sets.newHashSet();
        Map<String,String> map = Maps.newHashMap();
        map.put("1","111");
        set.add(map.get("111"));
        set.add(map.get("222"));
        set.add(map.get("333"));
        set.add(map.get("333"));
        set.add(map.get("333"));
        set.add(map.get("333"));
        set.add(map.get("333"));
        set.add(map.get("333"));
        set.add(map.get("333"));
        set.add(map.get("333"));
        System.out.println(set.size());
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        long start1 = System.currentTimeMillis();
        if (StringUtil.isNotEmpty(map.get("111"))&&StringUtil.isNotEmpty(map.get("111"))&&StringUtil.isNotEmpty(map.get("111"))&&StringUtil.isNotEmpty(map.get("111"))&&StringUtil.isNotEmpty(map.get("111"))&&StringUtil.isNotEmpty(map.get("111"))&&StringUtil.isNotEmpty(map.get("111"))&&StringUtil.isNotEmpty(map.get("111"))&&StringUtil.isNotEmpty(map.get("111"))&&StringUtil.isNotEmpty(map.get("111"))){
            System.out.println("end-start");
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);
    }
}*/
