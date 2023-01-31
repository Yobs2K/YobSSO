package com.example.core.configuration;

import com.example.core.assemblers.TestClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {
    @Bean
    public TestClass testClass(){
        return new TestClass("pivo");
    }
}
