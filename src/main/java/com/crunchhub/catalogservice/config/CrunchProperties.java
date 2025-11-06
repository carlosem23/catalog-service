package com.crunchhub.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "crunchhub")
public class CrunchProperties {

    /**
     * Just a fun message :)
     */
    private String greeting;
    public String getGreeting() {
        return greeting;
    }
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
