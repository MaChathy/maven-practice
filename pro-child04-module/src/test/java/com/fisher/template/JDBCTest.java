package com.fisher.template;

import com.fisher.mybatis.entry.Employee;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 测试装配JdbcTemplate
 * @author fisher
 * @version 1.0.1 2023/6/11 - 18:54
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class JDBCTest {

    @Autowired
    @Qualifier(value = "druidDataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier(value = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.debug("测试装配JdbcTemplate, connection = "+connection);
    }

    @Test
    public void testJdbcTemplateUpdate() {
        String sql = "update t_emp set emp_salary = ? where emp_name = ?";
        int update = jdbcTemplate.update(sql,9.9,"李冲");
        log.debug("update = " + update);
    }

    @Test
    public void testJdbcTemplateQueryForObject() {
        String sql = "select * from t_emp where emp_name= ?";

        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql,rowMapper,"李冲");

        log.debug("employ = " + employee);
    }

    @Test
    public void testJdbcTemplateQueryAll(){
        String sql = "select * from t_emp";

        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> query = jdbcTemplate.query(sql, rowMapper);
        for(var e: query)
            log.debug(e.toString());
    }

    @Test
    public void testTransaction(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();


    }
}
