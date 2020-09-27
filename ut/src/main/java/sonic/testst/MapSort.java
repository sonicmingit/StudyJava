package sonic.testst;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * map排序
 * hashMap换成treemap直接排序
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-9-14 17:02
 **/
public class MapSort {

    private static void setMap(Map map){
        map.put("NXDJ0001","一级");
        map.put("NXDJ0002","二级");
        map.put("NXDJ0003","三级");
        map.put("NXDJ0004","四级");
        map.put("NXDJ0005","五级");
    }

    private static void showMap(Map map){
        map.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }


    public static void main(String[] args) {
        Map<String,String> hash = Maps.newHashMap();
        setMap(hash);
        showMap(hash);
        Map<String,String> tree = Maps.newTreeMap();
        setMap(tree);
        showMap(tree);
    }

}