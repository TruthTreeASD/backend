package edu.northeastern.truthtree.service.login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTests {

    @Mock
    private LoginService loginService;

    @Test
    public void testAuthenticateUser() {
        String password = "truthtree123";
        loginService.authenticateUser(password);
        verify(loginService, times(1)).authenticateUser(password);
    }
}
