package hu.nive.ujratervezes.zarovizsga.peoplesql;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class PeopleDao {

    private JdbcTemplate jdbcTemplate;

    public PeopleDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public String findIpByName(String fistName, String lastName) {
        String sql = "SELECT ip_address from people where first_name = ? and last_name =?";
        return jdbcTemplate.queryForObject(sql,new Object[]{fistName, lastName} , String.class);
    }
}
