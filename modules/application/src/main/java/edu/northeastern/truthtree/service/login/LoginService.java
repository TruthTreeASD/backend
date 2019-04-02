package edu.northeastern.truthtree.service.login;
import static edu.northeastern.truthtree.AppConst.PASSWORD_HASH;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class LoginService implements ILoginService {

  @Override
  public Boolean authenticateUser(String password) {
    return BCrypt.checkpw(password, PASSWORD_HASH);
  }

}
