package sonic.ut;
import com.alibaba.fastjson.TypeReference;
import org.powermock.modules.junit4.PowerMockRunner;
import sonic.pojo.OkSub11;
import com.google.common.collect.Lists;
import sonic.pojo.OkSub1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import sonic.pojo.Ok;
import sonic.pojo.OkSub2;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * IDEA报错解决
 * 1. Error running 'ServiceStarter': Command line is too long.
 * .....
 * A: .idea\workspace.xml -> <component name="PropertiesComponent"> -> <property name="dynamic.classpath" value="true" />
 */


//注释的方式装载Mockito
//@RunWith(MockitoJUnitRunner.class)
/*另一个mock方法,可以mock静态方法.这边用了注解,mock可以用前置方法*/
@RunWith(PowerMockRunner.class)
public class AccountLoginControllerTest {


    private AccountDao accountDao;

    private HttpServletRequest request;

    /**
     * 类似service,controller等可以用这个注解mock
     * 创建一个实例，简单的说是这个Mock可以调用真实代码的方法，其余用@Mock（或@Spy）注解创建的mock将被注入到用该实例中。
      */
    // 要测试的类添加此注解可进方法
    @InjectMocks
    private AccountLoginController accessController;

    /**
     * 创建一个mock
     * 同代码里 HttpServletRequest request1 = Mock(HttpServletRequest.class)
     */
    // 只是mock,所有方法返回都得mock
    @Mock
    private HttpServletRequest request1;


    @Before
    public void setUp(){
        /*前置的方式初始化Mcokito,和类注解@RunWith(MockitoJUnitRunner.class)都可以*/
        MockitoAnnotations.initMocks(this);
        //其他初始化参数
        this.accountDao = mock(AccountDao.class);
        this.request =  mock(HttpServletRequest.class);
        this.accessController = new AccountLoginController(accountDao);


        /*mock静态方法实例 todo 后续补充*/
        //mock权限校验静态方法,跳过用户权限校验
        /*PowerMockito.mockStatic(ParamCheckUtils.class); //创建mock
        PowerMockito.doNothing().when(ParamCheckUtils.class);
        ParamCheckUtils.userParamCheck(Mockito.any());*/ //mock方法返回
    }

    @Test
    public void login() {
        Account account = new Account();
        // 对mock方法进行mock返回
        when(request.getParameter("username")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        // 对mock方法进行任意参数返回
        when(accountDao.findAccount(anyString(),anyString())).thenReturn(account);
        // junit断言
        assertEquals(accessController.login(request),"/index");

        Account account1 = null;
        when(accountDao.findAccount(anyString(),anyString())).thenReturn(account1);
        assertEquals(accessController.login(request),"/login");

        when(accountDao.findAccount(anyString(),anyString())).thenThrow(new UnsupportedOperationException());

        assertEquals(accessController.login(request),"/505");
    }



    @Test
    public void testDo(){
        Ok ok = createDo();
        String jsonStr = JSONObject.toJSONString(ok);
        System.out.println(jsonStr);
        //用json创建一个实体
        String json = "{\"ok1\":{\"ok11\":{},\"okDouble\":1.1,\"okInt\":2,\"okStr\":\"222\"},\"ok2\":[{\"okDouble\":3.3,\"okInt\":3,\"okStr\":\"333\"}],\"okDouble\":1.1,\"okInt\":1,\"okStr\":\"111\"}\n";
        Ok doByJson = createDoByJson(json);
        System.out.println(doByJson);
        Ok doByJson1 = createDoByJson(json,ok);
        System.out.println(doByJson1);
    }


    /**
     * 用json串创建一个实体
     * @return
     */
    private Ok createDoByJson(String jsonStr){
        JSONObject json = JSONObject.parseObject(jsonStr);
        Ok ok = JSON.toJavaObject(json,Ok.class);
        return ok;
    }

    /**
     * 用json串创建一个实体
     * @param jsonStr
     * @param t
     * @param <T>
     * @return
     */
    private <T> T createDoByJson(String jsonStr,T t){
        JSONObject json = JSONObject.parseObject(jsonStr);
        T t2 = (T) JSON.toJavaObject(json, t.getClass());
        return t2;
    }

    /**
     * 直接创建一个实体
     * @return
     */
    private Ok createDo(){
        Ok ok = new Ok();
        ok.setOkStr("111");
        ok.setOkInt(1);
        ok.setOkDouble(1.1D);
        // ok1
        OkSub1 ok1 = new OkSub1();
        ok1.setOkStr("222");
        ok1.setOkInt(2);
        ok1.setOkDouble(1.1D);
        ok1.setOk11(new OkSub11());
        // end ok1
        ok.setOk1(ok1);
        // ok2
        OkSub2 ok2 = new OkSub2();
        ok2.setOkStr("333");
        ok2.setOkInt(3);
        ok2.setOkDouble(3.3D);
        //end ok2
        ok.setOk2(Lists.newArrayList(ok2));
        return ok;
    }
}