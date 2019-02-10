package edu.northeastern.truthtree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class LandingController {

  @GetMapping({"/", "/index"})
  public String home() {

    return "index";
  }
}

