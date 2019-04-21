package edu.northeastern.truthtree.controller.login;

import edu.northeastern.truthtree.service.login.ILoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
public class Login implements ILogin {

  private ILoginService service;

  @Autowired
  public Login(ILoginService service) {
    this.service = service;
  }

  @RequestMapping(value = "/api/login", method = RequestMethod.POST)
  public void authenticateUser(@RequestBody String password, HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) {
    Boolean authenticateUser = service.authenticateUser(password);
    HttpSession httpSession = httpServletRequest.getSession();
    if (authenticateUser) {
      httpSession.setAttribute("admin", true);
      httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    } else {
      // wrong login
      httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
  }
}
