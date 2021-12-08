import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * ip查询接口
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-7-13 11:06
 * https://market.aliyun.com/products/57002003/cmapi021970.html?spm=5176.2020520132.101.2.6d95721830irq3#sku=yuncode1597000000
 **/
public class IP {

    public static void main(String[] args) {
        String host = "https://api01.aliyun.venuscn.com";
        String path = "/ip";
        String method = "GET";
        String appcode = "602a8adc62c54576b4861c02d36b0678";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("ip", "218.18.228.178");


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse httpResponse = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(httpResponse.toString());
            //获取response的body
            System.out.println(httpResponse.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}