package edu.northeastern.truthtree.controller.login;

public interface ILogin {
  /**
   * Authenticates a user.
   *
   * @param password containing user provided password
   * @return a boolean value indicating if the user is authenticated or not
   */
  Boolean authenticateUser(String password);
}
