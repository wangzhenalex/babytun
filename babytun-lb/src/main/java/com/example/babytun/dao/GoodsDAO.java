package com.example.babytun.dao;

import com.example.babytun.entity.Goods;

public interface GoodsDAO {
    Goods findById(Long goodsId);
}
