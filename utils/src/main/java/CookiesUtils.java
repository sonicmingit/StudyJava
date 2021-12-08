import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: SpringBootDemo
 * @description: Cookies相关方法
 * @author: hao.yiming
 * @create: 2020-2-24 17:06
 **/
public class CookiesUtils {

    /**
     * Cookie生效时间
     */
    public static final int COOKIE_TIME = 60 * 60 * 24 * 365;

    public static void setCookies(HttpServletResponse response) {
        Cookie cookie;
        //设置语言cookie
        cookie = new Cookie("test", "succeed");
        cookie.setPath("/");
        // 保存时间(秒),负值关闭即删除
        cookie.setMaxAge(COOKIE_TIME);
        //添加Cookie
        response.addCookie(cookie);
    }

    public static Cookie[] getCookies(HttpServletRequest request){
        //获取当前Cookies
        Cookie[] cookies = request.getCookies();
        //循环Cookies
        for (Cookie cookie : cookies) {
            //查找需要的cookie
            if ("test".equals(cookie.getName())) {
                System.out.println(cookie.getName()+":"+cookie.getValue());
                break;
            }
            //打印cookies
            System.out.println(cookie.getName()+":"+cookie.getValue());
        }
        return cookies;
    }
}
