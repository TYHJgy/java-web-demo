package com.example.spring.exercise.dao;

import com.example.spring.exercise.dao.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

     public User selectUserByUserId(String userId) {
         String sql = "SELECT * FROM user WHERE userId = ?";
         User user = jdbcTemplate.queryForObject(sql,(resultSet, rowNum) -> {
                     User newActor = new User();
             newActor.setAge(resultSet.getString("age"));
             newActor.setUserName(resultSet.getString("userName"));
             newActor.setBirthday(resultSet.getString("birthday"));
             newActor.setUserId(resultSet.getString("userId"));
             LOGGER.info("rowNum="+rowNum);
             return newActor;
         },userId);
         return user;
    }
    public int insertUser(User user) {
        String sql = "INSERT INTO user (userName,age,birthday) VALUES (:USERNAME,:AGE,:BIRTHDAY)";
        MapSqlParameterSource msps = new MapSqlParameterSource();
        msps.addValue("USERNAME", user.getUserName());
        msps.addValue("AGE", user.getAge());
        msps.addValue("BIRTHDAY", user.getBirthday());
        return this.namedParameterJdbcTemplate.update(sql, msps);
    }

    public int updateUser(User user) {
        String sql = "UPDATE user SET userName = :USERNAME , age = :AGE , birthday = :BIRTHDAY WHERE `userId` = :UID";
        MapSqlParameterSource msps = new MapSqlParameterSource();
        msps.addValue("USERNAME", user.getUserName());
        msps.addValue("AGE", user.getAge());
        msps.addValue("BIRTHDAY", user.getBirthday());
        msps.addValue("UID", user.getUserId());
        return this.namedParameterJdbcTemplate.update(sql, msps);
    }

    public int deleteUser(String uid){
        String sql = "DELETE FROM user WHERE userId = :UID";
        MapSqlParameterSource msps = new MapSqlParameterSource();
        msps.addValue("UID",uid);
        return this.namedParameterJdbcTemplate.update(sql, msps);
    }

    public List<User> selectAllUser() {
        String sql = "SELECT * FROM user";
        return namedParameterJdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }

}
