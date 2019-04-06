package edu.northeastern.truthtree.service.login;

public interface ILoginService {
  /**
   * Authenticates a user.
   *
   * @param password containing user provided password
   * @return a boolean value indicating if the user is authenticated or not
   */
  Boolean authenticateUser(String password);

}
