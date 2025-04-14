package com.hobart.springbootmall.dao;

import com.hobart.springbootmall.dto.OrderQueryParams;
import com.hobart.springbootmall.model.Order;
import com.hobart.springbootmall.model.OrderItem;
import java.util.List;

public interface OrderDao {

  Integer countOrder(OrderQueryParams orderQueryParams);

  List<Order> getOrders(OrderQueryParams orderQueryParams);

  Order getOrderById(Integer orderId);

  List<OrderItem> getOrderItemsListByOrderId(Integer orderId);

  Integer createOrder(Integer userId, Integer totalAmount);

  void createOrderItems(Integer orderId, List<OrderItem> orderItemList);


}
