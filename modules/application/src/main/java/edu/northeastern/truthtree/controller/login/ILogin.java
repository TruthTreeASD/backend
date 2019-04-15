package edu.northeastern.truthtree.controller.login;

import java.security.Principal;

public interface ILogin {
  /**
   * Authenticates a user.
   *
   * @param password containing user provided password
   * @return a boolean value indicating if the user is authenticated or not
   */
  Boolean authenticateUser(String password);
}
