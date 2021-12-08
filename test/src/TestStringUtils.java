import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Date;

/**
 * 字符串工具测试
 *
 * @author: sonic.hao(郝一鸣)
 * @date: 2021-8-27 14:00
 **/
public class TestStringUtils {

    @Test
    public void testblank(){
        String[] contents = {"",null," ","   ",","};


        for (String content : contents) {
            if (content == null || content.trim().length() == 0) {
                System.out.println(content+":"+1);
            }

            if (StringUtils.isBlank(content)) {
                System.out.println(content+":"+"isBlank");
            }

            if (StringUtils.isEmpty(content)) {
                System.out.println(content+":"+"isEmpty");
            }
            if (StringUtils.isEmpty(content)||StringUtils.isBlank(content.replace(",",""))){
                System.out.println(content+":"+"replace");
            }
        }

    }


    @Test
    public void test(){
        String sms = " , , , , , ";

        System.out.println(sms.split(","));
        System.out.println(sms.split(",").length);


    }
}