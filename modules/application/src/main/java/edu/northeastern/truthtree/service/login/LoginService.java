package edu.northeastern.truthtree.service.login;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginService implements ILoginService {

  @Value("${passwordHash}")
  private String passwordHash;

  @Override
  public Boolean authenticateUser(String password) {
    return BCrypt.checkpw(password, passwordHash);
  }

}
