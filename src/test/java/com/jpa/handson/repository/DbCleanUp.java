package com.jpa.handson.repository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("test")
public class DbCleanUp implements InitializingBean {

    @PersistenceContext
    private EntityManager entityManager;

    private List<String> tableNames;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void execute() {
        for (final String tableName : tableNames) {
            JdbcTestUtils.deleteFromTables(jdbcTemplate, tableName);
        }

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        tableNames = entityManager.getMetamodel().getEntities().stream()
                .filter(e -> e.getJavaType().getAnnotation(Table.class) != null)
                .map(e -> "tst." + e.getJavaType().getAnnotation(Table.class).name())
                .collect(Collectors.toList());
    }
}
