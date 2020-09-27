package sonic.testst;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import sonic.pojo.Ok;

import java.util.Map;

/**
 * 同一指向对象删除
 * 创建一个map(a),令dto的一个map属性指向a,删除a的某一项,dto中map也会删除
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-9-7 16:25
 **/
public class DtoDel {


    static Map<String,String> map = Maps.newHashMap();

    static{
        map.put("test1","1111");
        map.put("test2","222");
    }

    static String Map2JsonStr(Map<String,String> map){
       return JSONObject.toJSONString(map);
    }

    static Map<String,String> JsonStr2Map(String str){
        return JSONObject.parseObject(str,Map.class);
    }

    public static void main(String[] args) {

        Ok ok = new Ok();
        Map map = Maps.newHashMap();
        map.put("1","11");
        map.put("2","22");
        map.put("3","33");
        ok.setMap(map);
        Map<String, String> featureMap = ok.getMap();
        featureMap.remove("1");
        ok.getMap().forEach((k,v)->{
            System.out.println(k+":"+v);
        });


    }


}