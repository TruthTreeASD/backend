package edu.northeastern.truthtree.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttributeResource {

    @RequestMapping("/api/attributes")
    public String attributeResource() {
        return "aaa";
    }
}
