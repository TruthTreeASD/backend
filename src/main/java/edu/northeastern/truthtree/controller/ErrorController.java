package edu.northeastern.truthtree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class ErrorController {

  @GetMapping("/error")
  public String error() {

    return "error";
  }
}