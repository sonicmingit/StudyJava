package sonic.testst;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.junit.Test;
import sonic.pojo.Ok;
import sonic.pojo.OkInt;
import sonic.pojo.OkSub1;

import java.util.Map;

/**
 * 随便测试
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-9-15 14:50
 **/
public class Testtt {



    @Test
    public void testJsonStr(){
        OkSub1 ok = new OkSub1();
        JSON.toJSONString(ok);
        System.out.println(JSON.toJSONString(ok));
    }

    public static void main(String[] args) {

        Map<String, String> errorMessages = Maps.newHashMap();
        //errorMessages.put("RULE_2020_1111_TMALL_CHANGE_RELATION_FORBIDDEN_1","dsdsadsd");
        errorMessages.put("RULE_2020_1111_TMALL_CHANGE_RELATION_FORBIDDEN_2","的说法的说法神盾非");
        StringBuilder eroMsg = new StringBuilder();
        StringBuilder eroCode = new StringBuilder();
        errorMessages.forEach((code,msg)->{
            eroCode.append(",").append(code);
            eroMsg.append(",").append(msg);
        });


        System.out.println(eroCode.substring(1).toString());
        System.out.println(eroMsg.substring(1).toString());

    }

    @Test
    public void testNull(){
        OkInt a = new OkInt() ;
        System.out.println(a.getOkInt());
        if (a.getOkInt()>0){
            System.out.println("22222");
        }else {
            System.out.println("#3333");
        }
    }

    @Test
    public void stringb(){
        StringBuilder sb = new StringBuilder();
        sb.append(1).append("2");
        System.out.println(sb);
    }
}