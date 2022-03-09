package com.jpa.handson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories(basePackages = "com.jpa.handson.repository")
public class OrmJpaHandsonApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(OrmJpaHandsonApplication.class, args);
    }


    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
//        ResourceDatabasePopulator resourceDatabasePopulator =
//                new ResourceDatabasePopulator(false, false, "UTF-8", new ClassPathResource("data.sql"));
//        resourceDatabasePopulator.execute(dataSource);
    }

}
