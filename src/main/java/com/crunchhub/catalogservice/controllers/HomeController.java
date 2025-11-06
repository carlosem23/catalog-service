package com.crunchhub.catalogservice.controllers;

import com.crunchhub.catalogservice.config.CrunchProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    private final CrunchProperties crunchProperties;
    public HomeController(CrunchProperties crunchProperties) {
        this.crunchProperties = crunchProperties;
    }

    @RequestMapping("/")
    public String index() {
        return crunchProperties.getGreeting();
    }
}