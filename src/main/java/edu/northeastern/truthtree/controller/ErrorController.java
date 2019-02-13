package edu.northeastern.truthtree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

/**
 * Represents the REST mapping for when an error occurs.
 */
@Controller
@ApiIgnore
public class ErrorController {

  /**
   * Forwards the URL to /error.jsp
   * @return error.jsp web page.
   */
  @GetMapping("/error")
  public String error() {

    return "error";
  }
}