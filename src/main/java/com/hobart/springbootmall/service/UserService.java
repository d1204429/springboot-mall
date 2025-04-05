package com.hobart.springbootmall.service;

import com.hobart.springbootmall.dto.UserLoginRequest;
import com.hobart.springbootmall.dto.UserRegisterRequest;
import com.hobart.springbootmall.model.User;

public interface UserService {

  Integer register(UserRegisterRequest userRegisterRequest);

  User getUserById(Integer userId);

  User login(UserLoginRequest userLoginRequest);

}
