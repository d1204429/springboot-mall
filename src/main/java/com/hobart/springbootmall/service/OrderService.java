package com.hobart.springbootmall.service;

import com.hobart.springbootmall.dto.CreateOrderRequest;
import com.hobart.springbootmall.model.Order;

public interface OrderService {

  Order getOrderById(Integer orderId);

  Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);


}
