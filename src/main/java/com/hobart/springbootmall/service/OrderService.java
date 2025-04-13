package com.hobart.springbootmall.service;

import com.hobart.springbootmall.dto.CreateOrderRequest;

public interface OrderService {

  Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);


}
