package org.example.babytunseckill.dao;

import org.example.babytunseckill.entity.Order;

public interface OrderDAO {
    void insert(Order order);
      Order findByOrderNo(String orderNo);
}
