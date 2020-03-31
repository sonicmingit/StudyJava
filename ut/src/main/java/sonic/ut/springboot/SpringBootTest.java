package sonic.ut.springboot;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * @program: StudyJavaSE
 * @description: spring autowired mockito单元测试
 * @author: hao.yiming
 * @create: 2020-3-31 23:26
 **/
public class SpringBootTest {

    //修饰内部包含@Autowird的Service类
    //使用@InjectMock置入需要测试的RegisterUserServiceImpl
    //@InjectMocks
    //private RegisterUserService registerUserService = new RegisterUserServiceImpl();

    //修饰Service类中自动装配(@Autowird)的类
    //对于需要mock掉的dao层的interface使用@Mock注入
    //@Mock

    //


    @Before
    public void setUp(){
        //Mockito初始化
        MockitoAnnotations.initMocks(this);
    }
}
