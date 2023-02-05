package com.example.web.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.db.repository")
@EntityScan("com.example.db.entity")
@ComponentScan(value = {
        "com.example.db",
        "com.example.core",
})
public class WebApplicationConfiguration {
}
