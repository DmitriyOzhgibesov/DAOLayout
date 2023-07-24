package ru.netology.daolayout;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public DBRepository dbRepository() {
        return new DBRepository();
    }
}
