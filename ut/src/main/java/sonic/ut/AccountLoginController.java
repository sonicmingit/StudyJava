package sonic.ut;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: StudyJavaSE
 * @description: 测试登录
 * @author: hao.yiming
 * @create: 2020-3-31 14:52
 **/
public class AccountLoginController {

    private final AccountDao accountDao;

    public AccountLoginController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String login(HttpServletRequest request){
        final String userName = request.getParameter("username");
        final String password = request.getParameter("password");
        try {
            Account account = accountDao.findAccount(userName,password);
            if (account==null){
                return "/login";
            }else {
                return "/index";
            }
        }catch (Exception e){
            return "/505";
        }
    }
}
