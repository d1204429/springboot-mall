package com.hobart.springbootmall.service;

import com.hobart.springbootmall.dto.CreateOrderRequest;
import com.hobart.springbootmall.dto.OrderQueryParams;
import com.hobart.springbootmall.model.Order;
import java.util.List;

public interface OrderService {

  Integer countOrder(OrderQueryParams orderQueryParams);

  List<Order> getOrders(OrderQueryParams orderQueryParams);

  Order getOrderById(Integer orderId);

  Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);


}
