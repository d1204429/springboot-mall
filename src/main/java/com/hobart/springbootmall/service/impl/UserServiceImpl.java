package com.hobart.springbootmall.service.impl;

import com.hobart.springbootmall.dao.UserDao;
import com.hobart.springbootmall.dto.UserRegisterRequest;
import com.hobart.springbootmall.model.User;
import com.hobart.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public Integer register(UserRegisterRequest userRegisterRequest) {
    return userDao.createUser(userRegisterRequest);
  }

  @Override
  public User getUserById(Integer userId) {
    return userDao.getUserById(userId);
  }
}
