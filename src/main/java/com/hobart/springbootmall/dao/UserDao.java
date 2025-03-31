package com.hobart.springbootmall.dao;

import com.hobart.springbootmall.dto.UserRegisterRequest;
import com.hobart.springbootmall.model.User;

public interface UserDao {

  Integer createUser(UserRegisterRequest userRegisterRequest);

  User getUserById(Integer userId);

}
