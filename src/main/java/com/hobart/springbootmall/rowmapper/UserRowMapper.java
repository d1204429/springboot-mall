package com.hobart.springbootmall.rowmapper;

import com.hobart.springbootmall.model.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(java.sql.ResultSet resultSet, int rowNum) throws java.sql.SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("user_id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setCreatedDate(resultSet.getObject("created_date", LocalDateTime.class));
        user.setLastModifiedDate(resultSet.getObject("last_modified_date", LocalDateTime.class));
        return user;
    }

}
