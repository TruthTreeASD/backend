package edu.northeastern.truthtree.service.login;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class LoginService implements ILoginService {


  @Override
  public Boolean authenticateUser(String password) {
    return BCrypt.checkpw(password, "$2a$10$bxqqs1qQ9CKptVf4IuxVGeN4yOkBAumtYNRL7mwXjVF6AoM7fbFle");
  }

}
