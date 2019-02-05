package edu.northeastern.truthtree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {

  @GetMapping({"/", "/index"})
  public String home() {

    return "index";
  }
}

