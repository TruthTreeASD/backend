package edu.northeastern.truthtree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

/**
 * Represents the REST mapping for when an the base URL for the application is hit.
 */
@Controller
@ApiIgnore
public class LandingController {

    /**
     * Forwards the URL to /index.jsp
     * @return index.jsp web page.
     */
    @GetMapping({"/", "/index"})
    public String home() {
        return "index";
    }
}

