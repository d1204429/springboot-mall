package com.hobart.springbootmall.dao.impl;

import com.hobart.springbootmall.dao.UserDao;
import com.hobart.springbootmall.dto.UserRegisterRequest;
import com.hobart.springbootmall.model.User;
import com.hobart.springbootmall.rowmapper.UserRowMapper;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public Integer createUser(UserRegisterRequest userRegisterRequest) {
    String sql = "INSERT INTO user (email, password, created_date, last_modified_date) "
        + "VALUES (:email, :password, :createDate, :lastModifiedDate)";
    Map<String, Object> map = new HashMap<>();
    map.put("email", userRegisterRequest.getEmail());
    map.put("password", userRegisterRequest.getPassword());

    LocalDateTime now = LocalDateTime.now();
    map.put("createDate", now);
    map.put("lastModifiedDate", now);

    KeyHolder keyHolder = new GeneratedKeyHolder();
    namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

    int userId = keyHolder.getKey().intValue();

    return userId;


  }

  @Override
  public User getUserById(Integer userId) {
    String sql = "SELECT user_id, email, password, created_date, last_modified_date "
        + "FROM user WHERE user_id = :userId";

    Map<String, Object> map = new HashMap<>();
    map.put("userId", userId);

    List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

    if (userList.size() > 0) {
      return userList.get(0);
    } else {
      return null;
    }

  }
}
