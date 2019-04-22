package edu.northeastern.truthtree.service.login;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.exceptions.misusing.NotAMockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoginServiceTests {

    @Autowired
    private LoginService loginService;

    @Test(expected = NotAMockException.class)
    public void testAuthenticateUser() {
        loginService.authenticateUser("truthtree123");
        verify(loginService, times(1)).authenticateUser("truthtree123");
    }
}
