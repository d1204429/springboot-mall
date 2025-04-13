package com.hobart.springbootmall.service.impl;

import com.hobart.springbootmall.dao.OrderDao;
import com.hobart.springbootmall.dao.ProductDao;
import com.hobart.springbootmall.dto.BuyItem;
import com.hobart.springbootmall.dto.CreateOrderRequest;
import com.hobart.springbootmall.model.OrderItem;
import com.hobart.springbootmall.model.Product;
import com.hobart.springbootmall.service.OrderService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderDao orderDao;

  @Autowired
  private ProductDao productDao;

  @Transactional
  @Override
  public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
    int totalAmount = 0;

    List<OrderItem> orderItemList = new ArrayList<>();

    for(BuyItem buyItem : createOrderRequest.getBuyItemList()){
      Product product = productDao.getProductById(buyItem.getProductId());

      //計算總價錢
      int amount = buyItem.getQuantity() * product.getPrice();
      totalAmount += amount;

      //轉換 BuyItem 為 OrderItem
      OrderItem orderItem = new OrderItem();
      orderItem.setProductId(buyItem.getProductId());
      orderItem.setQuantity(buyItem.getQuantity());
      orderItem.setAmount(amount);

      orderItemList.add(orderItem);
    }

    Integer orderId = orderDao.createOrder(userId, totalAmount);

    orderDao.createOrderItems(orderId, orderItemList);

    return orderId;
  }

}
