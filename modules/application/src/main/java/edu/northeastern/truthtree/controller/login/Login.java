package edu.northeastern.truthtree.controller.login;

import edu.northeastern.truthtree.service.login.ILoginService;
import java.security.Principal;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class Login implements ILogin {
  private ILoginService service;

  @Autowired
  public Login(ILoginService service) {
    this.service = service;
  }

  @RequestMapping(value = "/api/login", method = RequestMethod.POST)
  public Boolean authenticateUser(@RequestBody String password, HttpSession httpSession, HttpServletResponse httpServletResponse) {
    Boolean authenticateUser = service.authenticateUser(password);
    if(authenticateUser) {
      httpSession.setAttribute("admin",true);
    }
    else {
      // wrong login
      httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
    return authenticateUser;
  }
}
