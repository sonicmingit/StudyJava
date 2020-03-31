package sonic.ut;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest {


    private AccountDao accountDao;

    private HttpServletRequest request;

    private AccountLoginController accessController;


    @Before
    public void setUp(){
        this.accountDao = mock(AccountDao.class);
        this.request =  mock(HttpServletRequest.class);
        this.accessController = new AccountLoginController(accountDao);
    }

    @Test
    public void login() {
        Account account = new Account();
        when(request.getParameter("username")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.findAccount(anyString(),anyString())).thenReturn(account);
        assertEquals(accessController.login(request),"/index");

        Account account1 = null;
        when(accountDao.findAccount(anyString(),anyString())).thenReturn(account1);
        assertEquals(accessController.login(request),"/login");

        when(accountDao.findAccount(anyString(),anyString())).thenThrow(new UnsupportedOperationException());

        assertEquals(accessController.login(request),"/505");
    }
}