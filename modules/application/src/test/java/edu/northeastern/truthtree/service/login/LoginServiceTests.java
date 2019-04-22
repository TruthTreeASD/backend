package edu.northeastern.truthtree.service.login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.exceptions.misusing.NotAMockException;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTests {

    private LoginService loginService;

    @Before
    public void setup() {
        loginService = new LoginService();
    }

    @Test(expected = NotAMockException.class)
    public void testAuthenticateUser() {
        loginService.authenticateUser("truthtree123");
        verify(loginService, times(1)).authenticateUser("truthtree123");
    }
}
