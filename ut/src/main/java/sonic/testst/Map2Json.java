package sonic.testst;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * map和jsonstr互转
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-9-7 16:25
 **/
public class Map2Json {


    static Map<String,String> map = Maps.newHashMap();

    static Map<String,Map<String,String>> map2 = Maps.newHashMap();

    static{
        map.put("test1",null);
        map.put("test2",null);
    }

    static String Map2JsonStr(Map<String,String> map){
       return JSONObject.toJSONString(map);
    }

    static Map<String,String> JsonStr2Map(String str){
        return JSONObject.parseObject(str,Map.class);
    }

    public static void main(String[] args) {

/*        String jsonStr = Map2JsonStr(Maps.newHashMap());
        Map<String, String> stringStringMap = JsonStr2Map(jsonStr);
        System.out.println(JsonStr2Map(""));
        System.out.println(JsonStr2Map("1111"));
        System.out.println(stringStringMap);*/

        // 多层嵌套map转json
        /*map2.put("map1",map);
        map2.put("map2",map);
        map2.put("map3",Maps.newHashMap());
        String jsonStr2 = JSONObject.toJSONString(map2);
        System.out.println(jsonStr2);
        Map<String,Map<String,String>> stringStringMap2 = JSONObject.parseObject(jsonStr2,Map.class);
        System.out.println(stringStringMap2);
        Map<String,String> map21 = stringStringMap2.get("map1");
        System.out.println(map21);
        Map<String,String> map31 = stringStringMap2.get("map3");
        System.out.println(map31);*/

        Map<String,String> map = Maps.newHashMap();
        map.put("111","null");
        map.put("1111","null");
        String jsonStr2 = JSONObject.toJSONString(map);
       // System.out.println(jsonStr2);
        Map<String, String> stringStringMap = JsonStr2Map(jsonStr2);
        System.out.println(stringStringMap);
        stringStringMap.forEach((k,v)->{
            stringStringMap.put(k,null);
        });
        System.out.println(stringStringMap);

    }


}