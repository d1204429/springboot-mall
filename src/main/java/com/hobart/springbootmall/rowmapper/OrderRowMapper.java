package com.hobart.springbootmall.rowmapper;

import com.hobart.springbootmall.model.Order;
import java.time.LocalDateTime;
import org.springframework.jdbc.core.RowMapper;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(java.sql.ResultSet resultSet, int rowNum) throws java.sql.SQLException {
        Order order = new Order();
        order.setOrderId(resultSet.getInt("order_id"));
        order.setUserId(resultSet.getInt("user_id"));
        order.setTotalAmount(resultSet.getInt("total_amount"));
        order.setCreatedDate(resultSet.getObject("created_date", LocalDateTime.class));
        order.setLastModifiedDate(resultSet.getObject("last_modified_date", LocalDateTime.class));
        return order;
    }

}
