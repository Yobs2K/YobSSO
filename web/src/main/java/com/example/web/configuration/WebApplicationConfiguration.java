package com.example.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {
        "com.example.db",
        "com.example.core",
})
public class WebApplicationConfiguration {

}
