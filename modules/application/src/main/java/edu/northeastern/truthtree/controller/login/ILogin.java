package edu.northeastern.truthtree.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ILogin {

  /**
   * Authenticates a user.
   *
   * @param password containing user provided password
   * @param httpServletRequest containing the user request
   * @param httpServletResponse containing user login response
   * @return a boolean value indicating if the user is authenticated or not
   */
  void authenticateUser(String password, HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse);
}
