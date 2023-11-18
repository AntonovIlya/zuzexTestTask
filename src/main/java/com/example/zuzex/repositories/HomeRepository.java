package com.example.zuzex.repositories;

import com.example.zuzex.model.Home;
import com.example.zuzex.model.HomeUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HomeRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public void update(int id, HomeUpdateDTO home) {
        String updateHomeById = String.format("update zuzex_service.homes set address=:address, \"userId\"=:userId where id=%s", id);
        BeanPropertySqlParameterSource beanPropertySqlParameterSource = new BeanPropertySqlParameterSource(home);
        namedParameterJdbcTemplate.update(updateHomeById, beanPropertySqlParameterSource);
    }

    public Home getById(int id) {
        String getHomeById = "select * from zuzex_service.homes where id=:id;";
        SqlParameterSource param = new MapSqlParameterSource("id", id);
        return namedParameterJdbcTemplate.queryForObject(getHomeById, param, BeanPropertyRowMapper.newInstance(Home.class));
    }

    public void save(Home home) {
        String createNewHome = "insert into zuzex_service.homes values (:id, :address, '{}', :userId);";
        BeanPropertySqlParameterSource beanPropertySqlParameterSource = new BeanPropertySqlParameterSource(home);
        namedParameterJdbcTemplate.update(createNewHome, beanPropertySqlParameterSource);
    }

    public void removeById(int id) {
        String removeHomeById = "delete from zuzex_service.homes where id=?;";
        jdbcTemplate.update(removeHomeById, id);

    }
}
