package com.jpa.handson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories(basePackages = "com.jpa.handson.repository")
public class OrmJpaHandsonApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrmJpaHandsonApplication.class, args);
    }



}
