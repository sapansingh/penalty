package com.inspection.penalty.repository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class serverasset {
    private final JdbcTemplate jdbcTemplate1;
    private final JdbcTemplate jdbcTemplate2;

    public serverasset(@Qualifier("secondaryJdbcTemplate") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
        this.jdbcTemplate2 = new JdbcTemplate();
      
    }

    public void doSomethingWithDatabase1() {
        String sql = "SELECT * FROM some_table";
        // Perform operations with jdbcTemplate1
        jdbcTemplate1.queryForList(sql).forEach(System.out::println);
    }

    public void doSomethingWithDatabase2() {
        String sql = "SELECT * FROM another_table";
        // Perform operations with jdbcTemplate2
        jdbcTemplate2.queryForList(sql).forEach(System.out::println);
    }
}

