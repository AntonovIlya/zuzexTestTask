package com.example.zuzex.repositories;

import com.example.zuzex.model.Resident;
import com.example.zuzex.model.User;
import com.example.zuzex.model.UserUpdateDTO;
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
public class UserRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    public void update(int id, UserUpdateDTO user) {
        String updateUserById = String.format("update zuzex_service.users set name=:name, age=:age, password=:password where id=%s;", id);
        BeanPropertySqlParameterSource beanPropertySqlParameterSource = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(updateUserById, beanPropertySqlParameterSource);
    }

    public User getById(int id) {
        String getUserById = "select * from zuzex_service.users where id=:id;";
        SqlParameterSource param = new MapSqlParameterSource("id", id);
        return namedParameterJdbcTemplate.queryForObject(getUserById, param, BeanPropertyRowMapper.newInstance(User.class));
    }

    public void save(User user) {
        String createNewUser = "insert into zuzex_service.users values (:id, :name, :age, :password);";
        BeanPropertySqlParameterSource beanPropertySqlParameterSource = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(createNewUser, beanPropertySqlParameterSource);
    }

    public void removeById(int id) {
        String removeUserById = "delete from zuzex_service.users where id=?;";
        jdbcTemplate.update(removeUserById, id);
    }

    public void addResident(int id, Resident resident) {
        String addResident = "update zuzex_service.homes set residents=array_append(residents, ?) where \"userId\"=?;";
        jdbcTemplate.update(addResident, resident.getName(), id);
    }
}
