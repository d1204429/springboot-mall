package com.hobart.springbootmall.service.impl;

import com.hobart.springbootmall.dao.UserDao;
import com.hobart.springbootmall.dto.UserRegisterRequest;
import com.hobart.springbootmall.model.User;
import com.hobart.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

  private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  private UserDao userDao;

  @Override
  public Integer register(UserRegisterRequest userRegisterRequest) {
    User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
    if (user != null){
      log.warn("該email {} 已被註冊", userRegisterRequest.getEmail());
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    return userDao.createUser(userRegisterRequest);
  }

  @Override
  public User getUserById(Integer userId) {
    return userDao.getUserById(userId);
  }
}
