package edu.northeastern.truthtree.temp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class HealthCheck {
    private static final String response = "Hello! Health check ok!";

    @RequestMapping("/health")
    public String healthCheck() {
        return response;
    }
}
